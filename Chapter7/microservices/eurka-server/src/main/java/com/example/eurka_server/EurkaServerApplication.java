package com.example.eurka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurkaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurkaServerApplication.class, args);
	}

}
