package com.example.xx2.service;

import com.example.xx2.model.Movie;
import com.example.xx2.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;


    @Override
    public List<Movie> getNowShowing() {
        List<Movie> movies = new ArrayList<>();
        return movies;
    }

    @Override
    public List<Movie> getShowingSoon() {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        movie = movieRepository.save(movie);
        log.info(movie.getName()+" berhasil di tambahkan");
        return movie;
    }

    @Override
    public Movie edit(Movie movie) {
        return null;
    }

}
