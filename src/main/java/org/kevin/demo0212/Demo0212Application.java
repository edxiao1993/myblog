package org.kevin.demo0212;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.kevin.demo0212.mapper")
public class Demo0212Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0212Application.class, args);
	}

}
