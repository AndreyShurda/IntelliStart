package com.intellias.lesson4.burgers;

public class Burger {
    String bun;
    int meat;
    int salad;

    {
        System.out.println("Non static initialization");
    }

    static {
        System.out.println("Static initialization");
    }

    public Burger(String bun) {
//        TODO
        this.bun = bun;
        System.out.println("constructor with one parameter");
    }

    public Burger(String bun, int meat) {
        this(bun);
        this.meat = meat;
        System.out.println("constructor with two parameters");
    }

    public Burger(String bun, int meat, int salad) {
        this(bun, meat);
        this.salad = salad;
        System.out.println("constructor with three parameters");
    }

    @Override public String toString() {
        return "Burger{" + "bun='" + bun + '\'' + ", meat=" + meat + ", salad=" + salad + '}';
    }
}
