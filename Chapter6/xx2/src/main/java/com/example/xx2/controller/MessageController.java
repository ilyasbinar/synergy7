package com.example.xx2.controller;

import com.example.xx2.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    MessageProducer messageProducer;

    @GetMapping("/send/{theMessage}")
    public String sendMessage(@PathVariable("theMessage") String theMessage){
        messageProducer.sendMessage("coming-soon-movie", theMessage);
        return "Message sent: "+theMessage;
    }


}
