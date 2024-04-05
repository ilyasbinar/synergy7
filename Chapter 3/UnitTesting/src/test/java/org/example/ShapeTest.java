package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    private final PrintStream printStream = System.out;

    @BeforeEach
    public void setUpPrint(){
        System.setOut(new PrintStream(byteArrayOutputStream));
    }
    @Test
    void triangeArea() {
        Shape shape = new Shape();
        Assertions.assertEquals(5, shape.triangeArea(5,2));
    }

    @Test
    void fileName() {
        Shape shape = new Shape();
        String namaFile = shape.namaFile();

        Assertions.assertTrue(true);
    }

    @Test
    void testSysout(){
        Shape shape = new Shape();
        shape.printHello();

        Assertions.assertEquals("Hello ini binar", byteArrayOutputStream.toString().trim());

    }

}