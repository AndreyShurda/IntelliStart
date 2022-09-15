package com.intellias.lesson16;

import com.intellias.lesson12.Employee;

public class CompanyEmployee extends Employee {
    private String companyName;

    public CompanyEmployee(int id, String name, int age, long salary) {
        super(id, name, age, salary);
    }

    public CompanyEmployee(int id, String name, int age, long salary, String companyName) {
        super(id, name, age, salary);
        this.companyName = companyName;
    }
}
