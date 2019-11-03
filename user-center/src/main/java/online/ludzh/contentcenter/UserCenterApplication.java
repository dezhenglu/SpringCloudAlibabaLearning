package online.ludzh.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "online.ludzh")
@SpringBootApplication
public class UserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCenterApplication.class, args);
	}

}
