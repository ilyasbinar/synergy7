package com.example.xx2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping("hello")
    public String helloWorld(){
        return "Hello World";
    }
}
