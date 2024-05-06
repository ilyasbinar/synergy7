package com.example.xx2.service;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    List<Movie> getNowShowing();
    List<Movie> getShowingSoon();

    Movie create(Movie movie);
    Movie edit(Movie movie);

    List<Movie> getAllMovie();

    List<Movie> getAllSUMovie();
    List<Movie> getAllBOMovie();

    List<Movie> getAllKelapaGadingMovie();

    Movie getMovie4();

    List<Movie> getAllMoviePageable(String movie, int page, int amount);

    void createByProcedure(String mi5, int i);

    void deleteByProcedure(UUID uuid);
}
