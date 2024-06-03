package com.example.xx2.service;

import com.example.xx2.model.CinemaMovie;
import com.example.xx2.repository.CinemaMovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CinemaMovieServiceImpl implements CinemaMovieService {
    final
    CinemaMovieRepository cinemaMovieRepository;

    public CinemaMovieServiceImpl(CinemaMovieRepository cinemaMovieRepository) {
        this.cinemaMovieRepository = cinemaMovieRepository;
    }

    @Override
    public boolean isAvailable(CinemaMovie cinemaMovie, int amount) {
        return cinemaMovie.getStock() >= amount;
    }

    @Override
    public void adjustStock(CinemaMovie cinemaMovie, int amount) {
        cinemaMovie.setStock(cinemaMovie.getStock()-amount);
        cinemaMovieRepository.save(cinemaMovie);
    }

    @Override
    public CinemaMovie getById(UUID id) {
        Optional<CinemaMovie> cinemaMovieOptional = cinemaMovieRepository.findById(id);
        if(cinemaMovieOptional.isEmpty()){
            throw new RuntimeException();
        }else{
            return cinemaMovieOptional.get();
        }
    }
}
