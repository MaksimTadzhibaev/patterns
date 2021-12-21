package ru.tadzh.proxy;

public class DirtyDishes implements Dishes {

    @Override
    public void getDishes() {
        System.out.println("Грязная посуда");
    }
}
