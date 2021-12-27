package ru.tadzh.Strategy;

import java.util.List;

public class VariantSort2 implements SortStrategy{
    @Override
    public SortStrategy sort(List<Object> list) {
        System.out.println("Variant2");
        return null;
    }
}