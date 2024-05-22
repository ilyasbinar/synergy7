package com.example.xx2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("hello")
    public String helloWorld(){
        System.out.println(passwordEncoder.encode("123456"));

        return "Hello World";
    }
}
