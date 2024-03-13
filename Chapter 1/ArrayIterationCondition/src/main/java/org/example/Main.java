package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String menu[] = {"Nasi Goreng", "Mie Goreng"};
        long harga[] = {15000, 130000};


        Scanner scanner = new Scanner(System.in);

        System.out.println("Ini menu");
        System.out.print("=>");
        int menuSelection = scanner.nextInt();

        System.out.println("Anda memilih menu: "+menuSelection);

        if(menuSelection>=1 || menuSelection<=5){
            //todo:
        } else if (menuSelection == 99) {
            //todo pesean dan bayar
        } else if (menuSelection == 0) {
            //todo keluar aplikasi
        }else{
            //todo. Salah pilih. Silakan ulang
        }


        //Array deklarasi
        int y[] = new int[4];

        // inisialisasi
        y[0]=50;
        y[1]=70;
        y[2]=100;
        y[3]=90;

        for(int i=0;i< y.length;i++){
//            System.out.println(i);
//            System.out.println(y[i]);
            System.out.println("i: "+i+". y["+i+"]: "+y[i]);
        }

        //while
        int j=0;
        while(j<y.length){
            System.out.println("j: "+j+". y["+j+"]: "+y[j]);
            j++;
        }


        //do-while
        /**
         *      jabatan     |    parent_id
         *      Presiden    |        null
         *      Gubernur    |       presiden
         *      Walikota    |       gubernur
         *      Camat
         *      Lurah
         *      RW
         *      RT
         *
         *
         *
         */

        //Condition, comparation
        j=0;
        while(j<y.length){
            if(y[j]<65){
                System.out.println("Tidak Lulus");
            } else if (y[j]<85) {
                System.out.println("Lulus");
            } else if (y[j]<95) {
                System.out.println("Lulus. Mantap!!");
            } else{
                System.out.println("Lulus. Perfect");
            }
            j++;
        }

    }


}