package org.example.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class Seller extends User {
    private Long id;
    private String address;
    private List<Product> productList;

    @Override
    public String totalTransaction() {
        //TODO: logic untuk menghitung total transaksi si seller
        return getName()+" total transaksi 10";
    }

    @Override
    public long totalPenjualan() {
        //hitung total penjualan si seller
        return 0;
    }
}