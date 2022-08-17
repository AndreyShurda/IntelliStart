package com.intellias.lesson4;

import com.intellias.lesson4.burgers.Burger;

public class CheeseBurger extends Burger {
    String cheese;

    public CheeseBurger(String bun, int meat, int salad) {
        super(bun, meat, salad);
        System.out.println("constructor CheeseBurger with 3 params");
    }

    public CheeseBurger(String bun, int meat, int salad, String cheese) {
        super(bun, meat, salad);
        this.cheese = cheese;
        System.out.println("constructor CheeseBurger with 4 params");
    }

    @Override public String toString() {
        return "CheeseBurger{" + "cheese='" + cheese + '\'' + super.toString() + '}';
    }
}
