package com.intellias.lesson4;

import com.intellias.lesson4.burgers.Burger;

import java.time.LocalDate;
import java.util.Arrays;

public class BurgerHouse {

    public static final String SLIED_BREAD = "slied bread";

    public static void main(String[] args) {
        Burger ciabata = new Burger("ciabata", 1, 1);
        System.out.println();
        Burger sliedBread = new Burger(SLIED_BREAD, 2, 1);
        Burger cheder = new CheeseBurger(SLIED_BREAD, 2, 1, "cheder");

        Cheese tofu = Cheese.of("tofu", 1);
        Cheese garganzola = Cheese.builder()
                .type("garganzola")
                .build();
        Cheese.builder()
                .type("garganzola")
                .count(23).build();
        tofu.setCount(6);

        System.err.println(tofu.toString());

        Burger[] burgers = new Burger[0];
        burgers = addBurger(burgers, ciabata);
        burgers = addBurger(burgers, sliedBread);
        burgers = addBurger(burgers, cheder);

        for (Burger burger : burgers) {
            System.out.println(burger);
        }

        int sumVarArg = sumVarArg(1, 5, 6);
        int sum = sum(new int[] { 1, 5, 6 });

    }

    private static Burger[] addBurger(Burger[] burgers, Burger burger) {
        Burger[] resizedSource = Arrays.copyOf(burgers, burgers.length + 1);
        resizedSource[resizedSource.length - 1] = burger;
        return resizedSource;
    }

    private static int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    private static int sumVarArg(int... array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
