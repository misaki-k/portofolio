package com.cosmeticsapp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CosmeticsappApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.exclude=static/**", "true");
		SpringApplication.run(CosmeticsappApplication.class, args);
	}
}
