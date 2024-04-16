package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDateUtil {
    private MyDateUtil(){};

    public static long getYearDifference(LocalDate date){
        return ChronoUnit.YEARS.between(date, LocalDate.now());
    }
}
