package ru.tadzh.Mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Server server = new Server();
        Client clientOne = new ClientOne();
        Client clientTwo = new ClientTwo();
        System.out.println("Открываем чат? если нет - stop");
        while (!"stop".equals(bufferedReader.readLine())) {
        server.setMessage(clientOne.sentMessage(bufferedReader.readLine()));
        System.out.println(server.getMessage());
        server.setMessage(clientTwo.sentMessage(bufferedReader.readLine()));
        System.out.println(server.getMessage());
        System.out.println("Продолжаем общение?");
        }
    }
}
