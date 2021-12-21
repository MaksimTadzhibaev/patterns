package ru.tadzh.flyweight;

import java.util.HashMap;

public class TeaShop {

    HashMap<Integer, Tea> ordersTea = new HashMap<>();

    TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker){
        this.teaMaker = teaMaker;
    }

    public void takeOrder(String teaType, int table) {
        ordersTea.put(table, teaMaker.make(teaType));
    }

    public void serve() {
        ordersTea.keySet().forEach(key -> System.out.println("Подан чай - " + key));
    }
}
