package org.example.view;

import org.example.controller.ProductController;
import org.example.model.entity.Product;
import org.example.model.entity.Variant;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class ProductView {
    public void displayProducts(Map<Long, Product> productMap){
        Set<Long> setId = productMap.keySet();
        displayHeader();
        for (Long key : setId) {
            displayProduct(productMap.get(key));
        }
    }

    private void displayHeader(){
        System.out.println("ID | Nama | Harga | Varian");
        System.out.println("=================");
    }
    private void displayProduct(Product product){
        /**
        if(product.getVariant()!= null) {
            System.out.println(product.getId() + " | " + product.getName() + " | " + product.getPrice() + " | " + product.getVariant().getDescription());
        }else{
            System.out.println(product.getId() + " | " + product.getName() + " | " + product.getPrice() + " | --" );
        }**/

        Optional<Product> productOptional = Optional.ofNullable(product);
        String description = productOptional
                .flatMap(Product::getVariant)
                .map(Variant::getDescription)
                .orElse("--");

        System.out.println(product.getId() + " | " + product.getName() + " | " + product.getPrice() + " | " +description);
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
