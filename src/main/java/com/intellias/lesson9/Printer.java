package com.intellias.lesson9;


import java.io.IOException;

public class Printer {

    public void printNumber(Object value) throws NullPointerException, PrinterException {
        print(value);
    }

    public static void print(Object value) throws NullPointerException, PrinterException{
        if (value == null) {
            throw new NullPointerException();
        } else if (value instanceof Float) {
            print(value, 1);
        } else if (value instanceof Double) {
            print(value, 2);
        } else {
            throw new PrinterException("Can not print value: " + value);
        }
    }

    public static void print(Object value, int count) {
        System.out.printf("Our object has value %." + count + "f\n", value);
    }
}
