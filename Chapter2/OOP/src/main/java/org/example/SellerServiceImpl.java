package org.example;

import java.util.List;

public class SellerServiceImpl implements SellerService{
    @Override
    public int getTotalProduct(Seller seller) {
        //
        return seller.getProductList().size();
    }

    @Override
    public List<Product> getProductList(Seller seller) {
        return seller.getProductList();
    }
}
