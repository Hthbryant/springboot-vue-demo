package com.example.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching//开启缓存注解
@ComponentScan(basePackages = "com.example")//扫包路径
@MapperScan(basePackages = "com.example.mapper")//扫描mapper
public class SpringbootServer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServer.class, args);
	}

}
