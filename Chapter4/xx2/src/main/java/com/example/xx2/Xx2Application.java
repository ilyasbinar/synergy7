package com.example.xx2;

import com.example.xx2.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing()
@SpringBootApplication
public class Xx2Application {

	public static void main(String[] args) throws InterruptedException {
		HomeController homeController = SpringApplication.run(Xx2Application.class, args).getBean(HomeController.class);
		homeController.home();
	}

}
