package com.intellias.lesson6;

public class Calculator {

    public static int add(int a, int b) {
        System.out.println("int signature");
        return (int) add(a, (double) b);
    }

    public static double add(double a, double b) {
        System.out.println("double signature");
        return a + b;
    }

    public static int add(Integer a, Integer b) {
        System.out.println("Integer signature");
        return (int) add(a.doubleValue(), b.doubleValue());
    }

    public static double add(String a, String b) {
        System.out.println("String signature");
        return add(Double.parseDouble(a), Double.parseDouble(b));
    }

    public static double add(String a, String b, String operation) {
        System.out.println("String signature");
        return add(Double.parseDouble(a), Double.parseDouble(b));
    }

}
