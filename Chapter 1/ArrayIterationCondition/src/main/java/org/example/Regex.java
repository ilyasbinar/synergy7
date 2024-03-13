package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {

        Pattern p = Pattern.compile(".s");
        Matcher m = p.matcher("as");
        boolean b = m.matches();

        boolean b2 = Pattern.compile(".s").matcher("as").matches();

        boolean b3 = Pattern.matches(".s", "as");

//        boolean b4 = Pattern.matches(".s", "asa");

        String[] student = {"Rian", "Taufik", "Firman", "Hamid"};

        boolean b4 = Pattern.matches(".*n", "Rian");

        for(int i=0;i<student.length;i++){
            if(Pattern.matches(".*n", student[i])){
                System.out.println(student[i]);
            }
        }

        System.out.println(b + " " + b2 + " " + b3+ " " + b4);
    }
}
