package com.example.xx2.service;

import com.example.xx2.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getNowShowing();
    List<Movie> getShowingSoon();

}
