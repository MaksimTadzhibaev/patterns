package ru.tadzh.Chain;

public class Main {
    public static void main(String[] args) {
        Sheet sheet = new SheetA4();
        SheetA3 sheetA3 = new SheetA3();
        sheet.setNextSheet(sheetA3);
        SheetA2 sheetA2 = new SheetA2();
        sheetA3.setNextSheet(sheetA2);
        sheet.print("Hello CHAIN");
    }
}
