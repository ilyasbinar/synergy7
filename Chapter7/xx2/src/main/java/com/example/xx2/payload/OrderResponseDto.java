package com.example.xx2.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderResponseDto {
    UUID orderId;
    String name;
}
