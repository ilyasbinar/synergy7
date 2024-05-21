package com.example.xx2.controller;

// Subsystem classes
class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}

class Tuner {
    public void on() {
        Amplifier amp = new Amplifier();
        amp.on();
        System.out.println("Tuner is on");
    }
}

// Client code
public class FacadePatternExample {
    public static void main(String[] args) {
        Tuner tuner = new Tuner();
        tuner.on();
    }
}
