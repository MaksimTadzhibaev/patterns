package ru.tadzh.Command;

public class Printer implements Command{

    @Override
    public String commandOn(String command) {
        if ("включить".equals(command)){
        return "Принтер включен";
        }
        else if ("выключить".equals(command)){
        return commandOff("Принтер выключен");
        }
        return "Принтер сломался";
    }
    @Override
    public String commandOff(String command) {
        return command;
    }
}
