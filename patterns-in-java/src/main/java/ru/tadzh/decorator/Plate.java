package ru.tadzh.decorator;

public class Plate implements Dishes{

    private Dishes dishes;

    public Plate(Dishes dishes) {
        this.dishes = dishes;
    }


    @Override
    public String name() {
        return dishes.name() + "тарелка";
    }

    @Override
    public String material() {
        return dishes.material() + "металлическая";
    }
}
