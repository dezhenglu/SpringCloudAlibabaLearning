package online.ludzh.contentcenter;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import online.ludzh.contentcenter.domain.dao.content.ShareMapper;
import online.ludzh.contentcenter.domain.entity.content.Share;
import online.ludzh.contentcenter.feignclient.TestBaiduFeignClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    ShareMapper shareMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public List<Share> testInsert(){
        Share share = new Share();
        // 1. 插入
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("xxx");
        share.setCover("xxx");
        share.setAuthor("加油");
        share.setBuyCount(1);
        shareMapper.insertSelective(share);
        // 2. 做查询; 查询当权数据库所有的share select * from share;
        List<Share> shares = this.shareMapper.selectAll();
        return shares;
    }

    /**
     * 测试: 服务发现,证明内容中心总能找到用户中心
     * @return 用户中心所有实例的地址信息
     */
    @GetMapping("/test2")
    public List<ServiceInstance> getInstances(){
        // 查询指定服务的所有实例的信息
        return this.discoveryClient.getInstances("user-center");
    }

    /**
     * 测试: 查询已经出册的服务列表
     * @return 注册中心注册的服务列表
     */
    @GetMapping("/test3")
    public List<String> getServices(){
        // 查询指定服务的所有实例的信息
        return this.discoveryClient.getServices();
    }

    @Autowired
    TestBaiduFeignClient testBaiduFeignClient;

    /**
     * 测试: Feign脱离Ribbon使用
     * @return
     */
    @GetMapping("/baidu")
    public String baiduIndex(){
        return testBaiduFeignClient.index();
    }

    @Autowired
    private TestService testService;

    @GetMapping("test-a")
    public String testA() {
        this.testService.common();
        return "test-a";
    }

    @GetMapping("test-b")
    public String testB() {
        this.testService.common();
        return "test-b";
    }

    @SentinelResource("hot")
    @GetMapping("test-hot")
    public String testHot(@RequestParam(required = false) String a, @RequestParam(required = false) String b) {
        return a + " " + b;
    }

    @GetMapping("test-sentinel-api")
    public String testSentinelAPI(@RequestParam(required = false) String a){
        // 定义一个Sentinel保护的资源, 名称是test-sentinel-api
        Entry entry = null;
        try {
            entry = SphU.entry("test-sentinel-api");
            // 被保护的业务逻辑
            if(StringUtils.isBlank(a)){
                throw new IllegalArgumentException("a不能为空");
            }
            return a;
        } catch (BlockException e) {
            // 如果被保护的资源被限流或者降级了, 就会抛BlockException
            log.warn("限流, 或者降级了" , e);
            return "限流, 或者降级了";
        } catch (IllegalArgumentException e2){
            // 统计IllegalArgumentException [发生次数, 发生占比]
            Tracer.trace(e2);
            return "参数非法!";
        }finally {
            if(entry != null){
                // 退出Entry
                entry.close();
            }
        }
    }
}
