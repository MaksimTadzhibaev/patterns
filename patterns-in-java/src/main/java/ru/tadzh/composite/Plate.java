package ru.tadzh.composite;

public class Plate implements Dishes{
    String name;

    String material;

    public Plate(String name, String material) {
        this.name = name;
        this.material = material;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
