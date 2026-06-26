package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableRetry
@EnableAsync
public class TestProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestProjectApplication.class, args);
	}

}
