package com.testprojg.testproja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestprojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestprojaApplication.class, args);
	}

}
