package com.example.schedulerdemo.service;

import com.example.schedulerdemo.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    void placeOrder(Order order);

    void placeOrderNewPropagation(Order order);

}
