package com.newsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class NewsAppLauncher {

	public static void main(String[] args) {
		SpringApplication.run(NewsAppLauncher.class, args);
	}

}
