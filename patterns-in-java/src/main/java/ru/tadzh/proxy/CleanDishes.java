package ru.tadzh.proxy;

public class CleanDishes implements Dishes {

    @Override
    public void getDishes() {
        System.out.println("Чистая посуда");
    }
}
