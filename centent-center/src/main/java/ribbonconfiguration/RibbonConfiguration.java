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
        // return new NacosWeightedRule();
        // return new NacosSameClusterWeightedRule();
        // return new NacosRule();
        return new NacosFinalRule();
    }
}
