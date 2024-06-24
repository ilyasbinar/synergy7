package com.example.schedulerdemo.service;

import com.example.schedulerdemo.model.OrderItem;
import com.example.schedulerdemo.model.Product;
import com.example.schedulerdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateProductQuantityWithRequiresNewPropagation(OrderItem item) {
        // Find the product
        Product product = productRepository.findById(item.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update the stock quantity
        int newQuantity = product.getQuantity() - item.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Insufficient stock");
        }
        product.setQuantity(newQuantity);
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
