package org.example;

import org.example.model.Employee;
import org.example.service.PriceService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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


        System.out.println("============");
        System.out.println("Lambda in collection");

        List<String> students = new ArrayList<>();
        students.add("Nisak");
        students.add("Naomi");
        students.add("Michelle");
        students.add("Marcel");

        //Konvensional
        System.out.println("===konvensional==");
        for (String s:students){
            System.out.println(s);
        }

        //Lambda
        System.out.println("===Lambda===");
        students.forEach(student -> System.out.println(student));

        System.out.println("===Method Reference===");
        students.forEach(System.out::println);

        //konvensional
//        for (String s:students){
//            if(s.length()>5) {
//                students.remove(s);
//            }
//        }

        //lambda
        students.removeIf(s -> s.length()>5);

        System.out.println("===Result===");
        students.forEach(System.out::println);


        System.out.println("====Employee====");

        Employee rahmi =  new Employee("1", "Rahmi", 10000000L);
        Employee nugrah = new Employee("2", "Nugrah", 15000000L);
        Employee jalil = new Employee("3", "Jalil", 20000000L);


        List<Employee> employeeList = Arrays.asList(
               rahmi,
                nugrah,
                jalil
        );

        System.out.println("ID | Nama | Gaji");
        employeeList.forEach(employee
                -> System.out.println(employee.getId()+". "+employee.getName()+" | "+employee.getSalary()));

//        employeeList.forEach(System.out::println);

        System.out.println("====Map====");
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("1", rahmi);
        employeeMap.put("2", nugrah);
        employeeMap.put("3", jalil);

        //konvensional
        System.out.println("====Konvensional====");
        for(Map.Entry<String, Employee> entry: employeeMap.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue().getNameAndSalary());
        }

        System.out.println("====Lambda====");
        employeeMap.forEach((key, value) -> System.out.println(key+": "+value.getNameAndSalary()));

    }
}