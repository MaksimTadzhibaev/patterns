package ru.tadzh.TemplateMethod;

public abstract class Builder {
    public final void metod0() {
        metod1();
        metod2();
        metod3();
        metod4();
    }

    protected abstract void metod1();
    protected abstract void metod2();
    protected abstract void metod3();
    protected abstract void metod4();
}