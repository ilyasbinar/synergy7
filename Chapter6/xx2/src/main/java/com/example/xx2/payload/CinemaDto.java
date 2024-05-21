package com.example.xx2.payload;

import com.example.xx2.model.Cinema;
import lombok.Data;

import java.util.UUID;

@Data
public class CinemaDto {
    private UUID id;

    private String name;
    private String address;
}
