package ru.tadzh.decorator;

public class Mug implements Dishes{

    private Dishes dishes;

    public Mug(Dishes dishes) {
        this.dishes = dishes;
    }

    @Override
    public String name() {
        return dishes.name() + "кружка";
    }

    @Override
    public String material() {
        return dishes.material() + "стеклянная";
    }
}
