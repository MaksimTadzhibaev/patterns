package ru.tadzh.decorator;

public class Main {
    public static void main(String[] args) {
        Dishes dishes = new SimpleDishes();
        System.out.println(dishes.name());
        System.out.println(dishes.material());

        Dishes dishesMug = new Mug(dishes);
        System.out.println(dishesMug.name());
        System.out.println(dishesMug.material());

        Dishes dishesPlate = new Plate(dishes);
        System.out.println(dishesPlate.name());
        System.out.println(dishesPlate.material());
    }
}
