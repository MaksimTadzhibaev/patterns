package ru.tadzh.Strategy;

import java.util.List;

public interface SortStrategy {
    SortStrategy sort(List<Object> list);
}