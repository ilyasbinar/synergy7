package com.example.demoTransactional.service;

import com.example.demoTransactional.model.Order;
import com.example.demoTransactional.model.Product;
import com.example.demoTransactional.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void adjustStock(Order order) {
        Product product = getById(order.getProduct().getId());

        product.setStock(product.getStock()- order.getQuantity());
        productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }
}
