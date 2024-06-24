package com.example.schedulerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerdemoApplication.class, args);
	}

}
