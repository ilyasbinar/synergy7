package com.example.consumer.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
 
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
 
}