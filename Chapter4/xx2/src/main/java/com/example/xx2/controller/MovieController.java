package com.example.xx2.controller;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Movie;
import com.example.xx2.service.CinemaService;
import com.example.xx2.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    CinemaService cinemaService;

    public void displayShowingMovie(){
        List<Movie> nowShowingMovies = movieService.getNowShowing();
        nowShowingMovies.forEach(movie -> System.out.println(movie.getName()));
        updateKelapaGadingAddress();
        deleteMovie4FromKg();
//        safeDeleteKgCinema();
//        showAllKelapaGadingMovie();
//        showAllSUMovie();
//        showAllMovie();
//        createMovie();

    }

    private void deleteMovie4FromKg() {
        Movie movie4 = movieService.getMovie4();
        Cinema cinemaKg = cinemaService.getCinemaKelapaGading();
//        cinemaService.deleteMovieInCinema(movie4, cinemaKg);
        cinemaService.safeDeleteMovieInCinema(movie4, cinemaKg);

    }

    private void updateKelapaGadingAddress() {
        Cinema cinemaKg = cinemaService.getCinemaKelapaGading();
        cinemaService.updateAddress(cinemaKg, "Jalan HIJ");
    }


    private void showAllKelapaGadingMovie() {
        //cara1
        System.out.println("==cara1==");
        List<Movie> movieList = new ArrayList<>();
        movieList = movieService.getAllKelapaGadingMovie();
        movieList.forEach(movie -> System.out.println(movie.getName()));

        //cara2
        System.out.println("==cara2==");
        Cinema cinemaKg = cinemaService.getCinemaKelapaGading();
        List<CinemaMovie> cinemaMovieKgList = cinemaService.getAllInCinema(cinemaKg);
        cinemaMovieKgList.forEach(cinemaMovie -> System.out.println(cinemaMovie.getMovie().getName()));

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

    public void showAllMovie(){
        List<Movie> movieList = movieService.getAllMovie();
        movieList.forEach(movie -> System.out.println(movie.getName()));
    }


    private void showAllSUMovie() {
        List<Movie> movieList = movieService.getAllSUMovie();
        movieList.forEach(movie -> System.out.println(movie.getName()));
    }
}
