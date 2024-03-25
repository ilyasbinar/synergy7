package org.example.service;

import org.example.model.entity.Product;
import org.example.model.entity.Seller;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int getTotalProduct();
    int getTotalProduct(Seller seller);

    Map<Long, Product> getProductList();
    Map<Long, Product> getProductList(boolean expired);


    List<Product> getProductList(Seller seller);

    Product create(Product product);
    Product update(Long id, Product product);

    Product setExpiredDate(Product product);
}
