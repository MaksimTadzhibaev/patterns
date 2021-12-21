package ru.tadzh.proxy;

public class WashDishesProxy implements WashDishes {

    Dishes dishes = new DirtyDishes();

    WashDishesInTheDishwasher washDishesInTheDishwasher = new WashDishesInTheDishwasher();

    @Override
    public Dishes getCleanDishes(Electricity electricity) {
        if ("-".equals(electricity.getElectricity())) {
            dishes.getDishes();
            System.out.println("Электричества нет");
            System.out.println("Моем посуду руками");
            dishes = new CleanDishes();
            dishes.getDishes();
            return dishes;
        } else {
            dishes.getDishes();
            System.out.println("Электричество есть");
            dishes = washDishesInTheDishwasher.getCleanDishes(electricity);
            dishes.getDishes();
            return dishes;
        }
    }
}
