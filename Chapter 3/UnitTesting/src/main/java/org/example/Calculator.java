package org.example;

public class Calculator {
    private final double pi=3.14;
    public int add(Integer i, Integer j){
        return i+j;
    }

    public double division(Integer i, Integer j){
        if(j==0){
            return 0;
        }else{
            return (double) i /j;
        }
    }
}