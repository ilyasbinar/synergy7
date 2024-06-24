package com.example.schedulerdemo.service;

import com.example.schedulerdemo.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void updateProductQuantityWithRequiresNewPropagation(OrderItem item);
}
