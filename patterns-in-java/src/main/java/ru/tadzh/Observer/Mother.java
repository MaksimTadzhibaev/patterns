package ru.tadzh.Observer;

public class Mother implements Houseman{
    @Override
    public void handleEvent(String on, String laundry, String rinse, String spin, String off) {
        System.out.println("Мама увидела, что состояние стиральной машины изменилось, она теперь = " +
                "\n включена: "+ on +
                "\n стирает: "+ laundry +
                "\n полоскает: "+ rinse +
                "\n отжимает: "+ spin +
                "\n выключена: "+ off);
    }
}
