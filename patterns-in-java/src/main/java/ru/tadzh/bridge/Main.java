package ru.tadzh.bridge;

public class Main {
    public static void main(String[] args) {
        Material materialIron = new Iron();
        Material materialGlass = new Glass();
        Dishes dishesPlate = new Plate(materialIron);
        dishesPlate.use();
        Dishes dishesMug = new Mug(materialGlass);
        dishesMug.use();
    }
}
