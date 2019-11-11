package online.ludzh.contentcenter;

import online.ludzh.contentcenter.domain.dao.content.ShareMapper;
import online.ludzh.contentcenter.domain.entity.content.Share;
import online.ludzh.contentcenter.feignclient.TestBaiduFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
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
}
