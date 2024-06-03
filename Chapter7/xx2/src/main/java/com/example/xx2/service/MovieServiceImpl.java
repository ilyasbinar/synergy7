package com.example.xx2.service;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.Movie;
import com.example.xx2.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getAllSUMovie() {
        return movieRepository.findByType(1);
    }
    @Override
    public List<Movie> getAllBOMovie() {
        return movieRepository.findByType(2);
    }

    @Override
    public List<Movie> getAllKelapaGadingMovie() {
        return movieRepository.findKelapaGadingMovie();
    }

    @Override
    public Movie getMovie4() {
        Optional<Movie> movie4Optional = movieRepository
                .findById(UUID.fromString("74d30167-7cdd-4fbc-8057-534644ba7676"));

        if(movie4Optional.isEmpty()) throw  new RuntimeException();
        return movie4Optional.get();
    }

    @Override
    public List<Movie> getAllMoviePageable(String movie, int page, int amount) {
        Pageable pageable = PageRequest.of(page-1, amount, Sort.by("name"));
        return movieRepository.findByNameLike(movie, pageable);
    }

    @Override
    public void createByProcedure(String mi5, int type) {
        movieRepository.movieInsertData(mi5, type);
    }

    @Override
    public void deleteByProcedure(UUID uuid) {
        movieRepository.movieDeleteData(uuid);
    }
}
