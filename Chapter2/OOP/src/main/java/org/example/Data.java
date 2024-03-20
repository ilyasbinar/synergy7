package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Product> productList = new ArrayList<>();
    public static List<Seller> sellerList = new ArrayList<>();
    public static void initiateProduct(){

        Seller ilyas = new Seller();
        ilyas.setDob(LocalDate.of(1987,2,2));
        ilyas.setId(1L);
        ilyas.setGender(User.Gender.MALE);
        ilyas.setName("Ilyas");
        ilyas.setAddress("Jakarta");

        Seller michele = new Seller();
        michele.setDob(LocalDate.of(2006,3,12));
        michele.setId(1L);
        michele.setGender(User.Gender.FEMALE);
        michele.setName("Michele");
        michele.setAddress("Singapore");


        Seller naomi = new Seller();
        naomi.setDob(LocalDate.of(2008,8,20));
        naomi.setId(2L);
        naomi.setGender(User.Gender.MALE);
        naomi.setName("Naomi");
        naomi.setAddress("Solo");

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
                150000, LocalDate.now(), LocalDate.now(), "", "Miyako", ilyas);

        //Dari @NoArgsConstructor
        Product sepatuAdidasL = new Product();

        productList.add(ip11);
        productList.add(galaxy11);
        productList.add(hondaSupra);
        productList.add(kipasMiyako);

        List<Product> productNaomi = new ArrayList<>();
        productNaomi.add(ip11);
        naomi.setProductList(productNaomi);

        List<Product> productMichele = new ArrayList<>();
        productMichele.add(galaxy11);
        productMichele.add(hondaSupra);
        michele.setProductList(productMichele);

        List<Product> productIlyas = new ArrayList<>();
        productIlyas.add(kipasMiyako);
        ilyas.setProductList(productIlyas);

        sellerList.add(michele);
        sellerList.add(naomi);
        sellerList.add(ilyas);
    }
}
