package ru.tadzh.bridge;

public class Mug implements Dishes {

    Material material;

    public Mug(Material material) {
        this.material = material;
    }

    @Override
    public void use() {
        System.out.println("Кружка из которой я пью " + material.getMaterial());
    }
}
