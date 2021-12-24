package ru.tadzh.Strategy;

import java.util.List;

public class VariantSort1 implements SortStrategy{
    @Override
    public SortStrategy sort(List<Object> list) {
        System.out.println("Variant1");
        return null;
    }
}