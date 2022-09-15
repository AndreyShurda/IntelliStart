package com.intellias.lesson16;

import java.util.List;

public interface SalaryCalculator<T> {

    public double sum(List<T> list);
}
