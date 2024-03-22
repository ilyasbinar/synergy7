package org.example.others;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public abstract class Menu {
    private String nama;
    private String harga;
    private boolean favorit;
}
