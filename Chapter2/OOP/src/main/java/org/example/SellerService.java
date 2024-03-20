package org.example;

import java.util.List;

public interface SellerService {
     int getTotalProduct(Seller seller);

     List<Product> getProductList(Seller seller);
}
