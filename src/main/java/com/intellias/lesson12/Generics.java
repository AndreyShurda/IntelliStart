package com.intellias.lesson12;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;

public class Generics {
    public static void main(String[] args) {
        sum(2.3, 6);
        String test = new String("test");
        String test2 = "test";
        System.out.println("equals Objects");
//        System.out.println(equals(1, 2.3));

        List<Object> objects = new ArrayList<>();

        objects.add("12");
        objects.add(12);
        objects.add(12.0);
        objects.add(new Object());

        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(10);
        integers.add(8);

        System.out.println("sum of elements: ");
        System.out.println(sum(integers));

        List<Number> list1 = Arrays.asList(1, 2, 25);
        print(list1);
        List<Serializable> list = Arrays.asList(1.0, "2.0", 25);
        print(list);
        List<Object> list2 = Collections.singletonList(integers);
        print(list2);

        integers.stream().filter(Objects::isNull).count();
    }

//    static double sum(double a, double b) {
//        return a + b;
//    }

    static int sum(int a, int b) {
        return a + b;
    }

    static float sum(float a, float b) {
        return a + b;
    }

    static double sum(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

//    static boolean equals(String a, String b){
//        return a.equals(b);
//    }

//    static boolean equals(Number a, Number b){
//        return a.equals(b);
//    }

    static <T extends Number & Comparable> boolean equals(T a, T b) {
        return a.compareTo(b) == 0;
    }

//    static double sum(List<Object> list){
//
//    }

//    static <T extends Number> double sum(List<T> list) {
//
//    }

    static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    static double print(List<? super Number> list) {
        double sum = 0;
        System.out.println("print elements");
        for (Object o : list) {
            System.out.println(o.getClass());
        }
        return sum;
    }
}
