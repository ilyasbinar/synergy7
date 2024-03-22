package org.example.service;

import org.example.Data;
import org.example.model.entity.Product;
import org.example.model.entity.Seller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    @Override
    public int getTotalProduct() {
        return Data.productMap.size();
    }

    @Override
    public int getTotalProduct(Seller seller) {
        //
        return seller.getProductList().size();
    }

    @Override
    public Map<Long, Product> getProductList() {
        return Data.productMap;
    }

    @Override
    public List<Product> getProductList(Seller seller) {
        return seller.getProductList();
    }

    @Override
    public Product create(Product product) {
        product.setCreatedDate(LocalDateTime.now());
        return Data.productMap.put(product.getId(), product);
    }

    @Override
    public Product update(Long id, Product product) {
        Product tobeUpdatedProduct = Data.productMap.get(id);
        tobeUpdatedProduct.setName(product.getName());
        tobeUpdatedProduct.setBrand(product.getBrand());
        //dst
        Data.productMap.replace(id, tobeUpdatedProduct);
        return tobeUpdatedProduct;
    }
}
