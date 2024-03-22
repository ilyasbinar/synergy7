package org.example.view;

import org.example.Data;
import org.example.model.entity.Product;
import org.example.controller.ProductController;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProductView {
    public void displayProducts(Map<Long, Product> productMap){
        Set<Long> setId = Data.productMap.keySet();
        displayHeader();
        for (Long key : setId) {
            displayProduct(Data.productMap.get(key));
        }
    }

    private void displayHeader(){
        System.out.println("ID | Nama | Harga");
        System.out.println("=================");
    }
    private void displayProduct(Product product){
        System.out.println(product.getId()+" | "+product.getName()+" | "+product.getPrice());
    }

    public void productForm() {
        Product product = new Product();

        Scanner scanner = new Scanner(System.in);
        System.out.print("ID:");
        long id =  scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nama:");
        String name = scanner.nextLine();

        System.out.print("Harga:");
        long price = scanner.nextLong();
        scanner.nextLine();

        product.setId(id)
                .setName(name)
                .setPrice(price);

        ProductController productController  = new ProductController();
        productController.add(product);
    }
}
