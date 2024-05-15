package com.example.xx2.service;

import com.example.xx2.model.Movie;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

public interface JasperService {
    byte[] getMovieListReport(List<Movie> movieList, String format) throws JRException;
}
