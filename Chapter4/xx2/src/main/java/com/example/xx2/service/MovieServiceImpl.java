package com.example.xx2.service;

import com.example.xx2.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Override
    public List<Movie> getNowShowing() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Dune 2023", 50000L));
        movies.add(new Movie("The Godfather", 60000L));
        return movies;
    }

    @Override
    public List<Movie> getShowingSoon() {
        return null;
    }
}
