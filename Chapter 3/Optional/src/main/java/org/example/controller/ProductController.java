package org.example.controller;

import org.example.model.entity.Product;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;
import org.example.view.MenuView;
import org.example.view.ProductView;

import java.util.Map;

public class ProductController {
    public void mainMenu(){
        displayProducts();

        MenuView menuView = new MenuView();
        menuView.displayMainMenu();
    }

    public void menuSelection(int selectedMenu){
        if(selectedMenu==1){
            ProductView productView = new ProductView();
            productView.productForm();

        } else if (selectedMenu==2) {
            //todo ubah
        } else if (selectedMenu==3) {
            //todo hapus
        }
    }

    public void displayProducts(){
        ProductService ps = new ProductServiceImpl();
        Map<Long, Product> productMap = ps.getProductList();

        ProductView pv = new ProductView();
        pv.displayProducts(productMap);
    }

    public void add(Product product) {
        ProductService productService = new ProductServiceImpl();
        productService.create(product);

        mainMenu();
    }
}
