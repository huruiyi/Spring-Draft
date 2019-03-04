package mybatis.example.demo;

import mybatis.example.demo.dao.UsersMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class DemoApplication {





	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
