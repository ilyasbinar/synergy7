package org.example.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {//implements Comparable{
    private Long id;
    private String name;
    private String type;
    private long price;
    private LocalDateTime createdDate;//waktu product ditambahkan
    private LocalDateTime updatedDate;//waktu product diubah
    private LocalDate productionDate;
    private LocalDate expiredDate;
    private String description;
    private String brand;
    private Seller seller;
    private Variant variant;

    public Optional<Variant> getVariant() {
        return Optional.ofNullable(variant);
    }
    Optional<Seller> getSellerOptional() {
        return Optional.ofNullable(seller);
    }

    public Seller getSeller(){
        return getSellerOptional().orElse(null);
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getLabel(){
        //membandingkan apakah type adalah smartphone
        if(type.equals("Smartphone")){
            if(price>1000000) return "Mahal";
            else return "Murah";
        } else if (type.equals("Motorcycle")) {
            if(price>5000000) return "Mahal";
            else return "Murah";
        } else return "N/A";
    }

    public String getLabelWithBrand(){
        /*
         jika product selain apple maka mahal ketika diatas 100000
         dan jika product Ducati maka mahal ketika diatas 500000
         */
        if(type.equals("Smartphone")){
            if(price>1000000 && !brand.equals("Apple")) return "Mahal";
            else return "Murah";
        } else if (type.equals("Motorcycle")) {
            if(price>5000000 && !brand.equals("Ducati")) return "Mahal";
            else return "Murah";
        } else return "N/A";
    }

//    @Override
//    public int compareTo(Product p) {
//        if (getType() == null || p.getType() == null) {
//            return 0;
//        }
//        return getType().compareTo(p.getType());
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return getType().compareTo(o.get);
//    }
}
