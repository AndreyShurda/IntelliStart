package com.intellias.lesson16;

import java.util.concurrent.Callable;

public class ConcatString {
    public static void main(String[] args) {
        String s = null;
        for (int i = 0; i < 10; i++) {
            s += "test";
        }

    }
}
