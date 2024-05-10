package com.example.xx2.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderRequestDto {
    UUID cinemaMovieId;
    UUID userId;
    int amount;
}
