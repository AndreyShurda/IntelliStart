package com.intellias.lesson9;


public class PrinterNumbers extends Printer {
    @Override
    public void printNumber(Object value) throws RuntimeException {
        if (value instanceof Number) {
            super.printNumber(value);
        } else {
            throw new PrinterException("value not a number: " + value);
        }
    }
}
