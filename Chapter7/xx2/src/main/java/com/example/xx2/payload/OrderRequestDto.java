package com.example.xx2.payload;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderRequestDto {
    @NotBlank
    UUID cinemaMovieId;

    @NotBlank
    UUID userId;

    @NotBlank
    @Min(1)
    @Max(10)
    int amount;
}
