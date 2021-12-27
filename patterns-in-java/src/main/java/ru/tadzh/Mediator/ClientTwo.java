package ru.tadzh.Mediator;

public class ClientTwo implements Client {


    @Override
    public String sentMessage(String message) {
        return "Клиент 2 пишет - " + message;
    }
}
