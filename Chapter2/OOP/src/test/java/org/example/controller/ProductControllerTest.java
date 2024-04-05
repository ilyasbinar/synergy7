package org.example.controller;

import org.example.Data;
import org.example.model.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    @Test
    void add() {
        ProductController productController = new ProductController();
        Product product = new Product();
        product.setId(6L);
        product.setName("Test");
        product.setPrice(5000L);
        productController.add(product);

        assertEquals(1, Data.productMap.size());
    }
}