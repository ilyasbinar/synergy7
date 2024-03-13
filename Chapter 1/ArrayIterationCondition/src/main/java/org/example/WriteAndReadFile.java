package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAndReadFile {
    public static final String PATH="/home/birruby/Documents/work/binar/sinergy7/git/filename.txt";
    public static final String PATHCSV="/home/birruby/Documents/work/binar/sinergy7/git/filename.csv";
    public static void main(String[] args) {
        File file = new File(PATH);
        File fileCSV = new File(PATHCSV);
        try {
            if (file.createNewFile()) {
                System.out.println("File Created");
            }else{
                System.out.println("File already exists");
            }

            if (fileCSV.createNewFile()) {
                System.out.println("File CSV Created");
            }else{
                System.out.println("File CSV already exists");
            }
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }

        writeFile();
        writeFileCSV();
    }

    public static void writeFile(){
        try {
            String invoice ="Ayam Goreng (5): 60.000\n" +
                    "Es Teh Manis (5): 15.000";
            FileWriter fileWriter = new FileWriter(PATH);
            fileWriter.write(invoice);
            fileWriter.close();
            System.out.println("Berhasil ditulis");
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }

    }
    public static void writeFileCSV(){
        try {
            String invoice ="Ayam Goreng,5,60.000\n" +
                    "Es Teh Manis,5,15.000";
            FileWriter fileWriter = new FileWriter(PATHCSV);
            fileWriter.write(invoice);
            fileWriter.close();
            System.out.println("Berhasil ditulis");
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }
    }
}
