package ru.tadzh.composite;

import java.util.ArrayList;
import java.util.List;

public class Dryer {

    List<Dishes> dishesList = new ArrayList<>();

    public void addDishes(Dishes dishes){
        dishesList.add(dishes);
    }

    public void showDishes(List<Dishes> dishesList){
        for (Dishes dishes: dishesList) {
            System.out.println("На сушилке лежит " + dishes.getMaterial() + " " + dishes.getName());
        }
    }
}
