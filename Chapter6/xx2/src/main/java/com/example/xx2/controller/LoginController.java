package com.example.xx2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginoauth")
    public String login() {
        System.out.println("Login");
        return "login";
    }
}