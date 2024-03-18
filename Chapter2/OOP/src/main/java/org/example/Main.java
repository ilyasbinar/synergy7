package org.example;

public class Main {
    public static void main(String[] args) {

        Data.initiateProduct();

        for(Product p:Data.productList){
            System.out.println(p.getName()+"("+p.getSeller().getName()+"): "+p.getLabelWithBrand());
        }



        System.out.println("Hello world");
    }
}