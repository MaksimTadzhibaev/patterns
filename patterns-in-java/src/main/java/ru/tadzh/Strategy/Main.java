package ru.tadzh.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Sorter sorter1 = new Sorter(new VariantSort1());
        Sorter sorter2 = new Sorter(new VariantSort2());

        sorter1.sort(list);
        sorter2.sort(list);
    }
}