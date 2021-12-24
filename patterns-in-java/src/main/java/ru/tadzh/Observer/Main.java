package ru.tadzh.Observer;

public class Main {
    public static void main(String[] args) {
        Dishwasher dishwasher = new Dishwasher();
        dishwasher.addHouseman(new Father());
        dishwasher.addHouseman(new Mother());
        dishwasher.setCondition("+", "-","-","-","-");
    }
}
