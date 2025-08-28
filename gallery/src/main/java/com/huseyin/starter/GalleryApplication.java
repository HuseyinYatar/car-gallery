package com.huseyin.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "controller")
@EntityScan(basePackages = "entity")
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan(basePackages = "service")
@ComponentScan(basePackages = "security")
@SpringBootApplication
public class GalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleryApplication.class, args);
	}

}
