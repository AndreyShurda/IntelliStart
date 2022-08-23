package com.intellias.lesson6.oop;

public class Animal implements Eater, Walker{
    public static final int CURRENT_YEAR = 2022;
    private String name;
    private Food food;
    private int birthday;
    private boolean isVaccinated;


    public Animal(String name) {
        this.name = name;
    }

    public Food getFood() {
        return food;
    }

    public int getBirthday() {
        return birthday;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public Animal(String name, Food food, int birthday, boolean isVaccinated) {
        this.name = name;
        this.food = food;
        this.birthday = birthday;
        this.isVaccinated = isVaccinated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public int getAge(){
        return CURRENT_YEAR - this.birthday;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", age=" + birthday +
                ", isVaccinated=" + isVaccinated +
                '}';
    }

    @Override
    public void eat() {
        System.out.println(this.getClass().getCanonicalName() + " is eating: " + this.food);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (birthday != animal.birthday) return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        return food != null ? food.equals(animal.food) : animal.food == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + birthday;
        return result;
    }
}
