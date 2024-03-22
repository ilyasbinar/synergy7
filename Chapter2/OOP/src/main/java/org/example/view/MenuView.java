package org.example.view;

import org.example.controller.ProductController;

import java.util.Scanner;

public class MenuView {
    public void displayMainMenu(){
        System.out.println("""
                1. Tambah
                2. Ubah
                3. Hapus
                """);
        System.out.print("Silakan Pilih Menu: ");
        Scanner scanner = new Scanner(System.in);
        int selectedMenu =  scanner.nextInt();
        ProductController productController = new ProductController();
        productController.menuSelection(selectedMenu);
    }
}
