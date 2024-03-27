package org.example;

import org.example.controller.ProductController;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
//        CollectionTutorial.set();
        Data.initiateProduct();
        ProductController pc = new ProductController();
        pc.mainMenu();


//        for(Product p:Data.productList){
//            System.out.println(p.getName()+"("+p.getSeller().getName()+"): "+p.getLabelWithBrand());
//            System.out.println("Total Transaksi: "+p.getSeller().totalTransaction());
//        }
//
//        System.out.println("======");
//
//        for(Seller s:Data.sellerList){
//            SellerService sellerService = new SellerService();
//            System.out.println("Jumlah produk "+s.getName()+"("+MyDateUtil.getYearDifference(s.getDob())+"): "
//                    +sellerService.getTotalProduct(s));
//        }
//        System.out.println("Hello world");
//
////        for(Product p:Data.productSet){
////            System.out.println(p.getName());
////        }
//
//        Set<Long> setId = Data.productMap.keySet();
//        for (Long key : setId) {
//            Product product = Data.productMap.get(key);
//            System.out.println(product.getName());
//        }
        //Alternatif
//        Set<Long> setId = Data.productMap.keySet();
//        Iterator<Long> iterator = setId.iterator();
//        while (iterator.hasNext()){
//            Long key = iterator.next();
//            Product product = Data.productMap.get(key);
//            System.out.println(product.getName());
//        }
    }
}