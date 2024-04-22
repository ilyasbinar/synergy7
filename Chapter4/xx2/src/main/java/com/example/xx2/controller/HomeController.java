package com.example.xx2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class HomeController {
    final
    MovieController movieController;

    public HomeController(MovieController movieController) {
        this.movieController = movieController;
    }

    public void home(){
        movieController.displayShowingMovie();
        home2();
    }

    public void home2(){
        movieController.displayShowingSoonMovie();
    }
}
