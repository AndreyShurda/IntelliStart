package com.intellias.lesson28;

import java.util.Objects;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(Double a, Double b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            throw new RuntimeException("one of input parameters is null");
        }
        return add(a.intValue(), b.intValue());
    }
}
