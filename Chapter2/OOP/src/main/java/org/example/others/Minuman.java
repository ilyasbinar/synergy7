package org.example.others;

public class Minuman extends Menu{
    private Kondisi kondisi;
    private long extraPrice;

    enum Kondisi{
        PANAS(1), DINGIN(2);

        private int value;

        Kondisi(int value) {
            this.value=value;
        }
    }
}
