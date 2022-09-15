package com.intellias.utils;

import java.util.Collection;

public class Utils {
    public static <T> void printCollection(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static <T> void printCollection(Collection<T> collection) {
        for (T t : collection) {
            System.out.println(t);
        }
    }

}