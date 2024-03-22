package org.example.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.model.entity.User;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class Buyer extends User {
    private Long id;
    private String address;

    @Override
    public String totalTransaction() {
        //TODO: logic untuk menghitung total transaksi si buyer
        return getName()+" total transaksi 10";
    }

    @Override
    public long totalPenjualan() {
        // disii saja dengan 0 karena buyer tidak punya penjualan
        return 0;
    }
}