package com.intellias.lesson12;

import com.intellias.lesson16.CompanyEmployee;
import com.intellias.utils.Utils;

import java.util.*;

public class CompareObjects {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(2);
        list.add(7);
        list.add(9);

        System.out.println("Before sort");
        System.out.println(list);
        Collections.sort(list);

        System.out.println("After sort");
        System.out.println(list);
//        Arrays.sort(list.toArray());


        Employee[] empArr = new Employee[5];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);
        empArr[4] = new Employee(22, "Arun", 23, 20000);
        empArr[5] = new CompanyEmployee(22, "Ivan", 55, 4550, "Intellias");


        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }

        };

        Comparator<Employee> ageComparator = (o1, o2) -> o1.getAge() - o2.getAge();

        Comparator<Employee> salaryAndAgeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if ((o1.getSalary() - o2.getSalary()) == 0) {
                    return o1.getAge() - o2.getAge();
                } else {
                    return (int) (o1.getSalary() - o2.getSalary());
                }
            }

        };

        System.out.println("employees before sort");
        Utils.printCollection(empArr);
        Arrays.sort(empArr);

        System.out.println("=====================================");
        System.out.println("employees after sort");
        Utils.printCollection(empArr);

        System.out.println("=====================================");
        Arrays.sort(empArr, salaryComparator);
        System.out.println("employees after sort via salaryComparator");
        Utils.printCollection(empArr);

        System.out.println("=====================================");
        Arrays.sort(empArr, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("employees after sort via ageComparator");
        Utils.printCollection(empArr);

        System.out.println("=====================================");
        Arrays.sort(empArr, salaryAndAgeComparator);
        System.out.println("employees after sort via salaryAndAgeComparator");
        Utils.printCollection(empArr);
    }

}
