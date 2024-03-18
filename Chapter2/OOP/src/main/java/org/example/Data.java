package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Product> productList = new ArrayList<>();
    public static void initiateProduct(){
        Seller michele = new Seller()
                .setId(1L)
                .setName("Michele")
                .setAddress("Singapore");


        Seller naomi = new Seller()
                .setId(2L)
                .setName("Naomi")
                .setAddress("Solo");

        //Buat object IPhone 11;
        Product ip11 = new Product(1L, "IPhone 11")
                .setType("Smartphone")
                .setBrand("Apple")
                .setPrice(100000000)
                .setSeller(naomi);

        Product galaxy11 = new Product(2L, "Galaxy S11");
        galaxy11.setType("Smartphone");
        galaxy11.setBrand("Samsung");
        galaxy11.setPrice(8000000);
        galaxy11.setSeller(michele);

        Product hondaSupra = new Product(3L, "Honda Supra 125");
        hondaSupra.setType("Motorcycle");
        hondaSupra.setBrand("Honda");
        hondaSupra.setPrice(1500000);
        hondaSupra.setSeller(michele);

        //Dari @AllArgumentConstructor
        Product kipasMiyako = new Product(4L, "Kipas Anging Standing", "Kipas Angin",
                150000, LocalDate.now(), LocalDate.now(), "", "Miyako", naomi);

        //Dari @NoArgsConstructor
        Product sepatuAdidasL = new Product();

        productList.add(ip11);
        productList.add(galaxy11);
        productList.add(hondaSupra);
        productList.add(kipasMiyako);
    }
}
