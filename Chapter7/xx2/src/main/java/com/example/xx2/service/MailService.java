package com.example.xx2.service;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final Environment env;

    private final JavaMailSender javaMailSender;

    public MailService(Environment env, JavaMailSender javaMailSender) {
        this.env = env;
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String mailAddress, String title, String mailMessage){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(env.getProperty("spring.mail.username"));
        message.setTo(mailAddress);
        message.setSubject(title);
        message.setText(mailMessage);
        javaMailSender.send(message);
    }
}
