package com.arkarmoe.springboot_caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@ComponentScan(basePackages = {"com.arkarmoe.springboot_caching.controller"})
public class SpringbootCachingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCachingApplication.class, args);
	}

}
