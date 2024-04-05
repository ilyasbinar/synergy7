package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("Do Nothing")
    void testNothing(){

    }

    @Test
    @DisplayName("Positive Test - Successful Addition")
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 8);
        Assertions.assertEquals(13, result);
    }

    @Test
    @DisplayName("Positive Test - Successful Division")
    void division() {
        Calculator calculator = new Calculator();
        double result = calculator.division(10, 4);
        Assertions.assertEquals(2.5, result);
    }

    @Test
    @DisplayName("Negative Test - Invalid Request")
    void testInvalidRequestAdition(){
        Calculator calculator =  new Calculator();
        Exception e = Assertions.assertThrows(
                NullPointerException.class, () -> calculator.add(null, null));

        Assertions.assertEquals("Cannot invoke \"java.lang.Integer.intValue()\" because \"i\" is null", e.getMessage());

    }
}