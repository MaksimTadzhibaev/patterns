package ru.tadzh.Iterator;

public class Main {
    public static void main(String[] args) {
        Dishwasher dishwasher = new Dishwasher("Indesit", new String[]{"Мощность - 1 Квт", "Скорость отжима - 1000 об/мин", "Расход воды -  л/стирка"});
        Iterator iterator = dishwasher.getIterator();
        System.out.println("Стриральная машина - " + dishwasher.getName());
        System.out.print("Основные функции - ");
        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + ", ");
        }
    }
}
