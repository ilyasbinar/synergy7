package com.example.demoTransactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DemoTransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTransactionalApplication.class, args);
	}

}
