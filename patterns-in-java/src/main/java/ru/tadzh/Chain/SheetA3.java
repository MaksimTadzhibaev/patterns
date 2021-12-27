package ru.tadzh.Chain;

public class SheetA3 extends Sheet {

    @Override
    void printText(String text) {
        System.out.println("печатаем текст на листе формата А3: " + text);
    }
}
