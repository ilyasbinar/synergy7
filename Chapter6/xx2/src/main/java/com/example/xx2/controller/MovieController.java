package com.example.xx2.controller;

import com.example.xx2.model.Cinema;
import com.example.xx2.model.Movie;
import com.example.xx2.payload.CinemaCreateRequestDto;
import com.example.xx2.payload.CinemaDto;
import com.example.xx2.payload.MovieListReportDto;
import com.example.xx2.service.CinemaService;
import com.example.xx2.service.JasperService;
import com.example.xx2.service.MovieService;
import net.sf.jasperreports.engine.JRException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    JasperService jasperService;

    @GetMapping("/generate/{format}")
    public ResponseEntity<Resource> getAll(@PathVariable String format) throws JRException {
        //format: pdf, xlsx

        //Dapatkan list of movie
        List<Movie> movieList = movieService.getAllMovie();
        List<MovieListReportDto> movieListReportDtoList = movieList.stream()
                .map(Movie::toDto)
                .toList();

        //convert list of movie menjadi array byte[] menggunakan jasperService
        byte[] reportContent = jasperService.getMovieListReport(movieListReportDtoList, format);

        //return ByteArrayResource
        ByteArrayResource resource = new ByteArrayResource(reportContent);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("movie-list."+format).build().toString())
                .body(resource);
    }
}
