package org.example.others;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionTutorial {
    public static void main(String[] args) {

        tryCatchDemo();
//        tryCatchWithResourcesDemo();

//        try {
//            throwDemo();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (ArithmeticException e){
//            throw new RuntimeException();
//        }
    }

    public static void tryCatchDemo(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("testerror.txt"));
            while (scanner.hasNext()) {
                int i = scanner.nextInt();
                int hasil = 100 / i;
                System.out.println(hasil);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (ArithmeticException e){
//            throw new RuntimeException();
//            //e.printStackTrace();
//        }
        finally {
            if(scanner !=null){
                scanner.close();
            }
        }
    }

    public static void tryCatchWithResourcesDemo(){
        try (Scanner scanner = new Scanner(new File("testerror.txt"));) {
            while (scanner.hasNext()){
                int i = scanner.nextInt();
                int hasil = 100 /i;
                System.out.println(hasil);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ArithmeticException e){
            throw new RuntimeException();
        }
    }

    public static void throwDemo() throws FileNotFoundException, ArithmeticException {

        Scanner scanner = new Scanner(new File("testerror.txt"));
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            int hasil = 100 /i;
            System.out.println(hasil);
        }
    }


}
