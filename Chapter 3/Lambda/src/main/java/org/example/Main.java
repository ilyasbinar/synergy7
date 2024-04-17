package org.example;

import org.example.service.PriceService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lambda");
        System.out.println("===================");

        //Consumer
        Consumer<String> consumer = t-> System.out.println(t);
        consumer.accept("Hello Consumer");

        //Biconsumer
        BiConsumer<String, Integer> biConsumer = (nama,umur)
                -> System.out.println("Nama saya "+nama+ ". Umur saya "+ umur);
        biConsumer.accept("Ilyas", 35);

        //Supplier
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Supplier<String> getTimeSupplier = () -> dtf.format(LocalDateTime.now());
        System.out.println(getTimeSupplier.get());

        //Predicate
        int batasUmur =35;
        Predicate<Integer> lesserThan = i -> (i <= batasUmur);
        if(lesserThan.test(30)){
            System.out.println("Lolos Kualifikasi");
        }else {
            System.out.println("Tidak Lolos Kualifikasi");
        }

        System.out.println("====================");

        //konvensional
        PriceService priceServiceImpl = new PriceService() {
            @Override
            public Long getPrice(String productCode) {
                if(productCode.equalsIgnoreCase("1111")) return 10000L;
                else if (productCode.equalsIgnoreCase("2222")) return 5000L;
                else return 0L;
            }
        };

        Long thePrice1111 = priceServiceImpl.getPrice("1111");
        System.out.println(thePrice1111);

        PriceService priceServiceImplLambda = productCode -> {
            if(productCode.equalsIgnoreCase("1111")) return 10000L;
            else if (productCode.equalsIgnoreCase("2222")) return 5000L;
            else return 0L;
        };

        Long thePrice2222 = priceServiceImplLambda.getPrice("2222");
        System.out.println(thePrice2222);
    }
}