package org.example.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDateUtil {
    public static long getYearDifference(LocalDate date){
        return ChronoUnit.YEARS.between(date, LocalDate.now());
    }
}
