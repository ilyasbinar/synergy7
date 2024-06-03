package com.example.xx2.service;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Movie;
import com.example.xx2.payload.CinemaCreateRequestDto;
import com.example.xx2.payload.CinemaDto;
import com.example.xx2.repository.CinemaMovieRepository;
import com.example.xx2.repository.CinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CinemaMovieRepository cinemaMovieRepository;
    @Override
    public Cinema getCinemaKelapaGading() {
        UUID uuidKG = UUID.fromString("4aef6ad1-db67-4078-83ca-5898c3e1c43b");
        Optional<Cinema> kgCinemaOptional = cinemaRepository.findById(uuidKG);
        if(kgCinemaOptional.isEmpty()){
            throw new RuntimeException();
        }
        return kgCinemaOptional.get();
    }

    @Override
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public List<CinemaMovie> getAllInCinema(Cinema cinema) {
        return cinemaMovieRepository.findByCinema(cinema);
    }

    @Override
    public void updateAddress(Cinema cinema, String address) {
        cinema.setAddress(address);
        cinemaRepository.save(cinema);
    }

    @Override
    public void deleteMovieInCinema(Movie movie, Cinema cinema) {
        CinemaMovie cinemaMovie = cinemaMovieRepository.findByMovieAndCinema(movie, cinema);
        cinemaMovieRepository.delete(cinemaMovie);
    }

    @Override
    public void softDeleteMovieInCinema(Movie movie, Cinema cinema) {
        CinemaMovie cinemaMovie = cinemaMovieRepository.findByMovieAndCinema(movie, cinema);

        //update
        cinemaMovie.setDeleted(true);
        cinemaMovieRepository.save(cinemaMovie);

    }

    @Override
    public void deleteCinema(Cinema cinema) {
        cinemaRepository.delete(cinema);
    }

    @Override
    public CinemaDto create(CinemaCreateRequestDto cinemaCreateRequestDto) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaCreateRequestDto.getName());
        cinema.setAddress(cinemaCreateRequestDto.getAddress());
        cinemaRepository.save(cinema);

        return modelMapper.map(cinema, CinemaDto.class);
    }

    @Override
    public Cinema update(UUID id, Cinema cinema) {
        cinema.setId(id);
        return cinemaRepository.save(cinema);
    }
}
