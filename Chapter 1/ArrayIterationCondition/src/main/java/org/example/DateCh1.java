package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DateCh1 {
    public static void main(String[] args) {
        Date now = new Date();

        System.out.println(now);
        System.out.println(now.getMonth());

        LocalDate nowLD = LocalDate.now();
        System.out.println(nowLD);
        System.out.println(nowLD.getMonth());

        LocalDateTime nowLDT = LocalDateTime.now();
        System.out.println(nowLDT);
        System.out.println(nowLDT.getMonth());
    }
}
