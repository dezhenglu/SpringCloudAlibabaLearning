package online.ludzh.contentcenter.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ludzh on 2019/11/12.
 */
@FeignClient(name = "baidu", url = "http://www.baidu.com")
public interface TestBaiduFeignClient {

    @GetMapping("")
    String index();
}
