package online.ludzh.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.ludzh")
@SpringBootApplication
public class ContentCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCenterApplication.class, args);
	}

}
