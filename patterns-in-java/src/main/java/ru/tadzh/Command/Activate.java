package ru.tadzh.Command;

public class Activate {
    Command commandPrinter = new Printer();

    String runCommand(String command){
        return commandPrinter.commandOn(command);
        }
    }
