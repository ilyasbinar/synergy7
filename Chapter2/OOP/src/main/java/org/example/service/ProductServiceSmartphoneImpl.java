package org.example.service;

import org.example.model.entity.Product;
import org.example.model.entity.Seller;

import java.util.List;
import java.util.Map;

public class ProductServiceSmartphoneImpl implements ProductService{
    @Override
    public int getTotalProduct() {
        return 0;
    }

    @Override
    public int getTotalProduct(Seller seller) {
        return seller.getProductList().size();
    }

    @Override
    public Map<Long, Product> getProductList() {
        return null;
    }

    @Override
    public Map<Long, Product> getProductList(boolean expired) {
        return null;
    }

    @Override
    public List<Product> getProductList(Seller seller) {
        return seller.getProductList();
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public Product setExpiredDate(Product product) {
        return null;
    }
}
