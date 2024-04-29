package com.example.xx2.service;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Movie;

import java.util.List;

public interface CinemaService {
    Cinema getCinemaKelapaGading();

    List<CinemaMovie> getAllInCinema(Cinema cinemaKg);

    void updateAddress(Cinema cinema, String address);

    void deleteMovieInCinema(Movie movie4, Cinema cinemaKg);

    void safeDeleteMovieInCinema(Movie movie, Cinema cinema);
}
