package com.example.demoDepoloyment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping("hello")
    public String helloWorld(){
        return "Hello World";
    }
}
