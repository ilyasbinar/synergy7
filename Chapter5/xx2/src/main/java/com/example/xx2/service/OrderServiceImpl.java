package com.example.xx2.service;

import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Order;
import com.example.xx2.model.User;
import com.example.xx2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    final
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(User user, CinemaMovie cinemaMovie, int amount) {
        Order order = Order.builder()
                .user(user)
                .cinemaMovie(cinemaMovie)
                .amount(amount).build();

        return orderRepository.save(order);
    }

    @Override
    public Order confirmOrder(Order order) {
        order.setSuccess(true);
        return orderRepository.save(order);
    }
}
