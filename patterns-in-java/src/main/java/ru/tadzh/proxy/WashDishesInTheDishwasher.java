package ru.tadzh.proxy;

public class WashDishesInTheDishwasher implements WashDishes{

    String power;
    Dishes dishes = new DirtyDishes();

    @Override
    public Dishes getCleanDishes(Electricity electricity) {
        if ("+".equals(electricity.getElectricity())){
        System.out.println("Моем посуду в посудомоечной машине");
        dishes = new CleanDishes();}
        return dishes;
    }
}
