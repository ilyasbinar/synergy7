package org.example;

import org.example.model.ItemPesanan;
import org.example.model.Menu;
import org.example.model.Pesanan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Menu ng = new Menu(1L, "Nasi Goreng", "NG", 15000);
        Menu mg = new Menu(2L, "Mie Goreng", "MG", 10000);
        Menu etm = new Menu(3L, "Es Teh Manis", "ETM", 5000);

        Pesanan pesanan1 = new Pesanan(1L, "ABC123", LocalDateTime.now(), null, null);

        ItemPesanan png = new ItemPesanan(1L, pesanan1, ng, 3);
        ItemPesanan petm = new ItemPesanan(2L, pesanan1, etm, 3);
        ItemPesanan pmg = new ItemPesanan(3L, pesanan1, mg, 1);

        List<ItemPesanan> itemPesanan1 = new ArrayList<>();
        itemPesanan1.add(png);
        itemPesanan1.add(petm);
        itemPesanan1.add(pmg);

        pesanan1.setItemPesananList(itemPesanan1);

        System.out.println("Nama Order : "+pesanan1.getKode());
        System.out.println("Nama | Jumlah | Total ");
        for (ItemPesanan ip:pesanan1.getItemPesananList()){
            System.out.println(ip.getMenu().getNama()+" | "+ip.getKuantitas()+" | "+ ip.getMenu().getHarga()*ip.getKuantitas());
        }
    }
}