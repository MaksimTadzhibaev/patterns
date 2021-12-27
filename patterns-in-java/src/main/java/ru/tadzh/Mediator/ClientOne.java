package ru.tadzh.Mediator;

public class ClientOne implements Client{

    @Override
    public String sentMessage(String message) {
        return "Клиент 1 пишет - " + message;

    }
}
