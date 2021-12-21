package ru.tadzh.flyweight;

import java.util.HashMap;

public class TeaMaker {
    private HashMap<String, Tea> tea = new HashMap<>();

    public Tea make (String wishes) {
        tea.putIfAbsent(wishes, new Tea());
        return tea.get(wishes);
    }
}
