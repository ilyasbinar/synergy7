package com.example.xx2.repository;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CinemaMovieRepository extends JpaRepository<CinemaMovie, UUID> {

    CinemaMovie findByMovieAndCinema(Movie movie, Cinema cinema);

    List<CinemaMovie> findByCinema(Cinema cinema);
}
