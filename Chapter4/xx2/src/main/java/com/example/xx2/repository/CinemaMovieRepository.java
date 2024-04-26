package com.example.xx2.repository;

import com.example.xx2.model.CinemaMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CinemaMovieRepository extends JpaRepository<CinemaMovie, UUID> {
    
}
