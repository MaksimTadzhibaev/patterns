package ru.tadzh.Chain;

public class SheetA4 extends Sheet{

    @Override
    void printText(String text) {
        System.out.println("печатаем текст на листе формата А4: " + text);
    }
}
