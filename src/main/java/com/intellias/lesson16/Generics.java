package com.intellias.lesson16;

import com.intellias.lesson12.Employee;
import com.intellias.utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Generics {

    public static void main(String[] args) {
        double d1 = 10.0;
        ///10.0000000000001
        double d2 = 20.0 / 2.0;

        new BigDecimal(12.00);

        System.out.println(d2);
        System.out.println(d1 == d2);

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(10, "Mikey", 25, 10000));
        employees.add(new Employee(20, "Arun", 29, 20000));
        employees.add(new Employee(5, "Lisa", 35, 5000));
        employees.add(new Employee(1, "Pankaj", 32, 50000));
        employees.add(new Employee(1, "Pankaj", 32, 60000));
        employees.add(new Employee(22, "Arun", 23, 20000));
        employees.add(new Employee(22, "Arun", 23, 20000));

        Utils.printCollection(employees);

        Set<Employee> uniqueEmployee = new HashSet<>(employees);
        System.out.println("==================================");
        Utils.printCollection(uniqueEmployee);

        Set<Employee> uniqueSortEmployee = new TreeSet<>(employees);
        System.out.println("==================================");
        Utils.printCollection(uniqueSortEmployee);
        Map<Person, String> map = new HashMap<>();

        Person ivan = new Person("Ivan", 45, new Address("Nova st.", "12a"));
        map.put(ivan, "test");
        ivan.getAddress().setNumber("13a");

        System.out.println("ivan: " + map.get(ivan));

        //buckets 16 [1..16]
        Map<Integer, String> mapInt = new HashMap<>();
        mapInt.put(23, "prize");
        mapInt.put(7, "test");
        System.out.println();
    }


}
