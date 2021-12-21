package ru.tadzh.facade;

public class Main {
    public static void main(String[] args) {
        Dishwasher dishwasher = new Dishwasher();
        DishwasherFacade dishwasherFacade = new DishwasherFacade(dishwasher);
        dishwasherFacade.turnOn();
        dishwasherFacade.turnOff();
    }
}
