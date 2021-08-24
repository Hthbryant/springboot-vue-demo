package com.example.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@MapperScan(basePackages = "com.example.mapper")
public class SpringbootServer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServer.class, args);
	}

}
