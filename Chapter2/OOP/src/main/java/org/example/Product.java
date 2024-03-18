package org.example;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {
    private Long id;
    private String name;
    private String type;
    private long price;
    private LocalDate productionDate;
    private LocalDate expiredDate;
    private String description;
    private String brand;
    private Seller seller;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getLabel(){
        if(type.equals("Smartphone")){
            if(price>1000000) return "Mahal";
            else return "Murah";
        } else if (type.equals("Motorcycle")) {
            if(price>5000000) return "Mahal";
            else return "Murah";
        } else return "N/A";
    }

    public String getLabelWithBrand(){
        if(type.equals("Smartphone")){
            if(price>1000000 && !brand.equals("Apple")) return "Mahal";
            else return "Murah";
        } else if (type.equals("Motorcycle")) {
            if(price>5000000 && !brand.equals("Ducati")) return "Mahal";
            else return "Murah";
        } else return "N/A";
    }
}
