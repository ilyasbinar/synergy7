package com.example.schedulerdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PromotionScheduler {

    @Scheduled(initialDelay = 1000, fixedDelay = 1000, cron = "* * * * * *")
    public void cronJob(){
        System.out.println("print cronJob");
    }
}
