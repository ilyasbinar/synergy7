package com.example.xx2.controller;

import com.example.xx2.model.Cinema;
import com.example.xx2.payload.CinemaCreateRequestDto;
import com.example.xx2.payload.CinemaDto;
import com.example.xx2.service.CinemaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("cinema")
public class CinemaController {

    @Autowired
    private ModelMapper modelMapper;
    final
    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @GetMapping
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("dto")
    @CrossOrigin(origins = "http://kompas.com")
    public List<CinemaDto> getAllDtos(){
        return cinemaService.getAll().stream()
                .map(cinema -> modelMapper.map(cinema, CinemaDto.class))
                .toList();
    }

    @GetMapping("/re")
    public ResponseEntity<Map<String, Object>> getAllRE(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        List<Cinema> cinemaList = cinemaService.getAll();
        List<CinemaDto> cinemaDtoList = cinemaList
                .stream()
                .map(cinema -> modelMapper.map(cinema, CinemaDto.class))
                .toList();
        data.put("cinemas", cinemaDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("challange")
    public ResponseEntity<List<Cinema>> getAllChallange(){
        return new ResponseEntity<>(cinemaService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('CINEMA')")
    public  ResponseEntity<Map<String, Object>> add(@RequestBody CinemaCreateRequestDto cinemaCreateRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("cinema", cinemaService.create(cinemaCreateRequestDto));
        response.put("data", data);


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add/wishlist")
    @PreAuthorize("hasRole('USER')")
    public  ResponseEntity<Map<String, Object>> addWishList(@RequestBody CinemaCreateRequestDto cinemaCreateRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("cinema", cinemaService.create(cinemaCreateRequestDto));
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @Secured({"CINEMA", "USER"})
    public Cinema add(@PathVariable("id") UUID idCinema, @RequestBody Cinema cinema){
        return cinemaService.update(idCinema, cinema);
    }
}
