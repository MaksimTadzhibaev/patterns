package ru.tadzh.decorator;

public class SimpleDishes implements Dishes{

    @Override
    public String name() {
        return "название - ";
    }

    @Override
    public String material() {
        return "материал - ";
    }
}
