package ru.tadzh.Strategy;

import java.util.List;

public class Sorter {

    SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public SortStrategy sort(List<Object> list){
        return this.strategy.sort(list);
    }
}