package ru.tadzh.facade;

public class DishwasherFacade {
    private Dishwasher dishwasher;

    public DishwasherFacade(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    public void turnOn(){
        dishwasher.getElectricShock();
        dishwasher.makeSound();
        dishwasher.showLoadingScreen();
        dishwasher.bam();
    }

    public void turnOff()
    {
        dishwasher.closeEverything();
        dishwasher.pullCurrent();
        dishwasher.sooth();
    }
}
