package com.example.xx2.controller;

import com.example.xx2.model.Cinema;
import com.example.xx2.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("cinema")
public class CinemaController {
    final
    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @GetMapping
    public List<Cinema> getAll(){
        return cinemaService.getCinemaList();
    }

    @GetMapping("re")
    public ResponseEntity<Map<String, Object>> getAllRE(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("cinemas", cinemaService.getCinemaList());

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public Cinema add(@RequestBody Cinema cinema){
        return cinemaService.create(cinema);
    }

    @PutMapping("{id}")
    public Cinema add(@PathVariable("id") UUID idCinema, @RequestBody Cinema cinema){
        return cinemaService.update(idCinema, cinema);
    }
}
