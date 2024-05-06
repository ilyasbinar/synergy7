package com.example.xx2.service;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Movie;

import java.util.List;
import java.util.UUID;

public interface CinemaService {
    Cinema getCinemaKelapaGading();

    List<Cinema> getCinemaList();

    List<CinemaMovie> getAllInCinema(Cinema cinemaKg);

    void updateAddress(Cinema cinema, String address);

    void deleteMovieInCinema(Movie movie4, Cinema cinemaKg);

    void softDeleteMovieInCinema(Movie movie, Cinema cinema);


    void deleteCinema(Cinema cinema);

    Cinema create(Cinema cinema);

    Cinema update(UUID id, Cinema cinema);
}
