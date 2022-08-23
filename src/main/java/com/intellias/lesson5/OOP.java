package com.intellias.lesson5;

import com.intellias.lesson5.oop.Animal;
import com.intellias.lesson5.oop.Food;
import com.intellias.lesson5.oop.Mammal;

public class OOP {
    public static void main(String[] args) {
        Food milk = Food.builder()
                .type("milk")
                .quantity("0.5l")
                .build();
        Animal cat = new Mammal("Cat", milk, 2020, false, "natural");
        Animal cat2 = new Mammal("Cat", milk, 2020, false, "natural");
        System.out.println("equals cats: " + cat.equals(cat2));

        Animal dog = new Animal("Dog", new Food("meat", "1 kg"), 2019, false);

        Mammal dogMammal = new Mammal(dog, "natural");



//        Mammal mause = new Animal("Mouse", "corn", 2022, false);//bad example

        System.out.println(cat);
        System.out.println(dog);
        System.out.println(dogMammal);

        System.out.println("================================");

        dog.eat();
        dogMammal.eat();

        boolean isAnimal = dogMammal instanceof Animal;
        boolean isMammal = dogMammal instanceof Mammal;

        System.out.println("isAnimal: " + isAnimal);
        System.out.println("isMammal: " + isMammal);

        System.out.println("================================");
        System.out.println("getClass: ");
        System.out.println("isAnimal: " + dogMammal.getClass().equals(Animal.class));
        System.out.println("isMammal: " + dogMammal.getClass().equals(Mammal.class));
    }
}
