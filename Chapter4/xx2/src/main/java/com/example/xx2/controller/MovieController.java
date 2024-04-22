package com.example.xx2.controller;

import org.springframework.stereotype.Component;

@Component
public class MovieController {
    public void displayShowingMovie(){
        System.out.println("Tampikan film-film yang sedang tayang");
    }

    public void displayShowingSoonMovie(){
        System.out.println("Tampikan film-film yang akan segera tayang");
    }
}
