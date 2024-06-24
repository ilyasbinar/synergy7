package com.example.demoTransactional.service;

import com.example.demoTransactional.model.Order;
import com.example.demoTransactional.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Transactional
    public void placeOrder(Order order, int status) {
        productService.adjustStock(order);
        create(order, 1);
        if(status==1) {
            throw new RuntimeException("Not implemented yet");
        }
    }
    public void create(Order order, int status) {
        //BEGIN
        orderRepository.save(order);
        //END
    }
}
