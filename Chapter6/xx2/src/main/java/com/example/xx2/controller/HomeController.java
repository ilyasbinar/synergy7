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
        mailService.sendMail("ilyas@lua.co.id", "Register Binarfud", "Token : 123456");
        return "Mail sent";
    }
}
