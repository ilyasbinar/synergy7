package com.example.xx2.service;

import com.example.xx2.model.CinemaMovie;

import java.util.UUID;

public interface CinemaMovieService {
    boolean isAvailable(CinemaMovie cinemaMovie, int amount);

    void adjustStock(CinemaMovie cinemaMovie, int amount);

    CinemaMovie getById(UUID id);
}
