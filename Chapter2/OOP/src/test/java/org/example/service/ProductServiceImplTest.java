package org.example.service;

import org.example.Data;
import org.example.model.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @Test
    void create() {
        Data.initiateProduct();

        int jumlahAwal = Data.productMap.size();

        Product product = new Product();
        product.setId(6L);
        product.setName("Test");
        product.setPrice(5000L);
        ProductService productService = new ProductServiceImpl();
        productService.create(product);

        assertEquals(jumlahAwal + 1, Data.productMap.size());

    }
    @Test
    void createCekNama() {
        Data.initiateProduct();

        int jumlahAwal = Data.productMap.size();

        Product product = new Product();
        product.setId(6L);
        product.setName("Test");
        product.setPrice(5000L);
        ProductService productService = new ProductServiceImpl();
        productService.create(product);

        Product productHasil = productService.getProductById(6L);

        assertEquals("Test", productHasil.getName());

    }

    @Test
    void createCekCreatedDate() {
        Data.initiateProduct();

        int jumlahAwal = Data.productMap.size();

        Product product = new Product();
        product.setId(6L);
        product.setName("Test");
        product.setPrice(5000L);
        ProductService productService = new ProductServiceImpl();
        productService.create(product);

        Product productHasil = productService.getProductById(6L);

        assertNotNull(productHasil.getCreatedDate());

    }

    @Test
    void getTotal() {
        Data.initiateProduct();

        int jumlahAwal = Data.productMap.size();

        Product product = new Product();
        product.setId(6L);
        product.setName("Test");
        product.setPrice(5000L);
        ProductService productService = new ProductServiceImpl();
        productService.create(product);

        assertEquals(jumlahAwal + 1, productService.getTotalProduct());

    }
}