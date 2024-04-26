package com.example.xx2.controller;

import com.example.xx2.model.Movie;
import com.example.xx2.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    public void displayShowingMovie(){
        List<Movie> nowShowingMovies = movieService.getNowShowing();
        nowShowingMovies.forEach(movie -> System.out.println(movie.getName()));
        createMovie();
    }

    public void displayShowingSoonMovie(){
        log.info("Info");
        System.out.println("Tampikan film-film yang akan segera tayang");
    }

    public void createMovie(){
        Movie theMovie = Movie.builder()
                .name("Dune 2023")
                .type(1)
                .build();

        theMovie = movieService.create(theMovie);

        System.out.println(theMovie.getId());
    }

}
