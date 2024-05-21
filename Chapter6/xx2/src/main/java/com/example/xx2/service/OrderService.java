package com.example.xx2.service;


import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Order;
import com.example.xx2.model.User;

public interface OrderService {
    Order createOrder(User user, CinemaMovie cinemaMovie, int amount);

    Order confirmOrder(Order order);
}
