package ru.tadzh.Chain;

public class SheetA2 extends Sheet{

    @Override
    void printText(String text) {
        System.out.println("печатаем текст на листе формата А2: " + text);
    }
}
