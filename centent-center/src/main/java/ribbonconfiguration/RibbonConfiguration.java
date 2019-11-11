package ribbonconfiguration;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import online.ludzh.contentcenter.configuration.NacosFinalRule;
import online.ludzh.contentcenter.configuration.NacosSameClusterWeightedRule;
import online.ludzh.contentcenter.configuration.NacosWeightedRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ludzh on 2019/11/8.
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        // nacos权重 负载均衡
        // return new NacosWeightedRule();
        // nacos权重 负载均衡 + 同集群有限调用
        // return new NacosSameClusterWeightedRule();
        // 同上, nacos 新版本增加这个功能
        return new NacosRule();
        // nacos 权重 同集群 版本限制
        // return new NacosFinalRule();
    }
}
