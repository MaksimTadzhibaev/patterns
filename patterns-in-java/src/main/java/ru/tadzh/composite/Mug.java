package ru.tadzh.composite;

public class Mug implements Dishes{
    String name;

    String material;

    public Mug(String name, String material) {
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
