package com.example.xx2.controller;

import com.example.xx2.model.Movie;
import com.example.xx2.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class Movie2Controller {

    @Autowired
    MovieService movieService;

    public void displayShowingMovie(){
        List<Movie> nowShowingMovies = movieService.getNowShowing();
        nowShowingMovies.forEach(movie -> System.out.println(movie.getName()+"--"+movie.getPrice()));
    }

    public void displayShowingSoonMovie(){
        log.info("Info");
        System.out.println("Tampikan film-film yang akan segera tayang");
    }

    public Movie create(Movie movie){
        movieService.create(movie);
        return null;
    }
}
