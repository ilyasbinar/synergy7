package org.example.service;

import org.example.model.entity.Product;
import org.example.model.entity.Seller;

import java.util.List;

public class SellerService {
    public int getTotalProduct(Seller seller) {
        return seller.getProductList().size();
    }

    public List<Product> getProductList(Seller seller) {
        return seller.getProductList();
    }
}
