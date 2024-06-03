package com.example.xx2.service;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Movie;
import com.example.xx2.payload.CinemaCreateRequestDto;
import com.example.xx2.payload.CinemaDto;

import java.util.List;
import java.util.UUID;

public interface CinemaService {
    Cinema getCinemaKelapaGading();

    List<Cinema> getAll();

    List<CinemaMovie> getAllInCinema(Cinema cinemaKg);

    void updateAddress(Cinema cinema, String address);

    void deleteMovieInCinema(Movie movie4, Cinema cinemaKg);

    void softDeleteMovieInCinema(Movie movie, Cinema cinema);


    void deleteCinema(Cinema cinema);

    CinemaDto create(CinemaCreateRequestDto cinemaCreateRequestDto);

    Cinema update(UUID id, Cinema cinema);
}
