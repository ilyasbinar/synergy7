package com.example.xx2.service;

import com.example.xx2.model.Movie;
import com.example.xx2.payload.MovieListReportDto;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

public interface JasperService {
    byte[] getMovieListReport(List<MovieListReportDto> MovieListReportDtoList, String format) throws JRException;
}
