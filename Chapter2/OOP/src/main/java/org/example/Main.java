package org.example;

public class Main {
    public static void main(String[] args) {

        Data.initiateProduct();

        for(Product p:Data.productList){
            System.out.println(p.getName()+"("+p.getSeller().getName()+"): "+p.getLabelWithBrand());
            System.out.println("Total Transaksi: "+p.getSeller().totalTransaction());
        }

        System.out.println("======");

        for(Seller s:Data.sellerList){
            SellerService sellerService = new SellerServiceImpl();
            System.out.println("Jumlah produk "+s.getName()+"("+MyDateUtil.getYearDifference(s.getDob())+"): "
                    +sellerService.getTotalProduct(s));
        }
        System.out.println("Hello world");
    }
}