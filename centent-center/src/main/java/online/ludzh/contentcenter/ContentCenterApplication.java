package online.ludzh.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.ludzh")
@SpringBootApplication
public class ContentCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCenterApplication.class, args);
	}

	// 在Spring容器中, 创建一个对象, 类型RestTemplate; 名称/ID : restTemplate
	// <bean id="restTemplate" class="online.ludzh.contentcenter.RestTemplate">
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
