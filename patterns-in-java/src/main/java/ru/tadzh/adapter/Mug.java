package ru.tadzh.adapter;

//кружка
public class Mug  implements Drinkable {

    @Override
    public void drink() {
        System.out.println("drink");
    }
}
