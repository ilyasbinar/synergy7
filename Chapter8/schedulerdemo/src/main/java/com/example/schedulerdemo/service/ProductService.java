package com.example.schedulerdemo.service;

import com.example.schedulerdemo.model.OrderItem;
import com.example.schedulerdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    void updateProductQuantityWithRequiresNewPropagation(OrderItem item);

    List<Product> getAll();

}
