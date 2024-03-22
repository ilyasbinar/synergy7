package org.example.others;

import java.util.*;

public class CollectionTutorial {
    public static void list(){
        List<String> students = new ArrayList<>();
        students.add("Yohanes");
        students.add("Hamid");
        students.add("Dimas");
        students.add("Naomi");
        students.add("Michelle");
        students.add("Rahmi");

        List<String> studentsAdditional = new ArrayList<>();
        studentsAdditional.add("Syihab");
        studentsAdditional.add("Jalil");

        students.addAll(studentsAdditional);

        students.add("Ilyas");

        System.out.println(students.get(5));
        System.out.println(students.indexOf("Dimas"));
        System.out.println("=========================");

        for(String s:students){
            System.out.println(s);
        }

        students.remove("Ilyas");
        System.out.println("=========================");

        for(String s:students){
            System.out.println(s);
        }

        System.out.println("=========================");


    }

    public static void set(){
//        Set<String> students = new HashSet<>();
//        Set<String> students = new LinkedHashSet<>();
        Set<String> students = new TreeSet<>();
        students.add("Yohanes");
        students.add("Hamid");
        students.add("Dimas");
        students.add("Naomi");
        students.add("Michelle");
        students.add("Rahmi");
        students.add("Dimas");
        /*
        Naomi
        Michelle
        Rahmi
        Dimas
        Yohanes
        Hamid
         */

        for(String s:students){
            System.out.println(s);
        }

        System.out.println("=========================");

        System.out.println("=========================");

        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("=========================");
    }
}
