package com.intellias.lesson5.oop;

public class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }

    String milk;

    public Mammal(String name, Food food, int birthday, boolean isVaccinated, String milk) {
        super(name, food, birthday, isVaccinated);
        this.milk = milk;
    }


    public Mammal(Animal animal, String milk) {
        super(animal.getName(), animal.getFood(), animal.getBirthday(), animal.isVaccinated());
        this.milk = milk;
    }


    @Override
    public void eat() {
        System.out.println("Mammal is eating in different way");
        super.eat();
    }

    public void eat(String s) {
        System.out.println("Mammal is eating in different way:" + s);
    }


    @Override
    public String toString() {
        return "Mammal{" +
                "milk='" + milk + '\'' +
                "} " + super.toString();
    }


}
