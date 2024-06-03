package com.example.xx2.controller;

import com.example.xx2.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    MailService mailService;

    @GetMapping("hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("secured")
    @Secured({"CINEMA", "USER"})
    public String secured(){
        return "Hello World";
    }

    @GetMapping("sendmail")
    public String sendMail(){
        /**
         * Steps:
         * 1. Buat App Password: Harus aktifkan 2-step-verification
         * 2. Tambahkan maven mail di pom.xml
         *      <dependency>
         * 			<groupId>org.springframework.boot</groupId>
         * 			<artifactId>spring-boot-starter-mail</artifactId>
         * 		</dependency>
         * 3. Tambahkan variable mail configuration di application.properties
         *      spring.mail.host=smtp.gmail.com
         *      spring.mail.port=587
         *      spring.mail.username=[email]
         *      spring.mail.password=[Gunakan App Password]
         *      spring.mail.properties.mail.smtp.auth=true
         *      spring.mail.properties.mail.smtp.starttls.enable=true
         * 4. Buat service. Lihat di MailService.java
         */

        mailService.sendMail("ilyas@lua.co.id", "Register Binarfud", "Token : 123456");
        return "Mail sent";
    }
}
