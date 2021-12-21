package ru.tadzh.proxy;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Electricity electricity = new Electricity("+");
        Dishes dishes = new DirtyDishes();
        WashDishesProxy washDishesProxy = new WashDishesProxy();
        washDishesProxy.getCleanDishes(electricity);
    }
}
