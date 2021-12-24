package ru.tadzh.TemplateMethod;

public class OneBuilder extends Builder {
    @Override
    protected void metod1() {
        System.out.println("1");
    }

    @Override
    protected void metod2() {
        System.out.println("2");
    }

    @Override
    protected void metod3() {
        System.out.println("3");
    }

    @Override
    protected void metod4() {
        System.out.println("4");
    }
}