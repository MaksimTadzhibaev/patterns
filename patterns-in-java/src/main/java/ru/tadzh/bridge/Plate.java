package ru.tadzh.bridge;

public class Plate implements Dishes{

    Material material;

    public Plate(Material material) {
        this.material = material;
    }

    @Override
    public void use() {
        System.out.println("Тарелка из которой я ем " + material.getMaterial());
    }
}
