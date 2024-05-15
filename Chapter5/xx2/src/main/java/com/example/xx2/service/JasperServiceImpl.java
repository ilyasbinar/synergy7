package com.example.xx2.service;

import com.example.xx2.model.Movie;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperServiceImpl implements JasperService {
    @Override
    public byte[] getMovieListReport(List<Movie> movieList, String format){

        JasperReport jasperReport;
        try {
            jasperReport = (JasperReport) JRLoader
                    .loadObject(ResourceUtils.getFile("movie-list-report.jasper"));
        } catch (JRException | FileNotFoundException e) {
            try {
                File file = ResourceUtils.getFile("classpath:jasper/movie-list-report.jrxml");
                jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
                JRSaver.saveObject(jasperReport, "movie-list-report.jasper");
            } catch (FileNotFoundException | JRException ex) {
                throw new RuntimeException(ex);
            }
        }

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(movieList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("total", String.valueOf(movieList.size()));
        parameters.put("merchantName", String.valueOf(movieList.size()));
        parameters.put("dateTime", String.valueOf(movieList.size()));

        JasperPrint jasperPrint;
        byte[] reportContent;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            switch (format){
                case "pdf" -> reportContent = JasperExportManager.exportReportToPdf(jasperPrint);
                case "xml" -> reportContent = JasperExportManager.exportReportToXml(jasperPrint).getBytes();
                default -> throw new RuntimeException();
            }
        } catch (JRException e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }

        return reportContent;
    }
}
