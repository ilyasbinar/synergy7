package com.example.unitTestingMockDemo.controller;

import com.example.unitTestingMockDemo.entity.Person;
import com.example.unitTestingMockDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    PersonService personService;

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("person/{id}")
    public Person hello(@PathVariable Long id){
        Person person = personService.getById(id);
        return person;
    }
}