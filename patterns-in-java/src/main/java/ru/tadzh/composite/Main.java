package ru.tadzh.composite;

public class Main {
    public static void main(String[] args) {
        Dishes dishesMug = new Mug("кружка", "стеклянная");
        Dishes dishesPlate = new Plate("тарелка", "железная");
        Dryer dryer = new Dryer();
        dryer.addDishes(dishesMug);
        dryer.addDishes(dishesPlate);
        dryer.showDishes(dryer.dishesList);
    }
}
