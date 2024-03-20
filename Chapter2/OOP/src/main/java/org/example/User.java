package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public abstract class User {
    private String name;
    private Gender gender; //1. Male 2. Female 3. Belum tahu
    private LocalDate dob;

    public abstract String totalTransaction();

    //CONTOH TIDAK BENAR
    public abstract long totalPenjualan();

    enum Gender{
        MALE(1), FEMALE(2);

        private int value;

        Gender(int value) {
            this.value=value;
        }
    }

}
