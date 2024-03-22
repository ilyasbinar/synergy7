package org.example.others;

public class Makanan extends Menu{
    private Pedas pedas;

    private long extraPrice;

    enum Pedas{
        TIDAK(1), SEDANG(2), SANGAT(3);

        private int value;

        Pedas(int value) {
            this.value=value;
        }
    }
}
