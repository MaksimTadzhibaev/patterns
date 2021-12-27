package ru.tadzh.Command;

public class Main {
    public static void main(String[] args) {
        Activate activate = new Activate();
        System.out.println(activate.runCommand("включить"));
    }
}
