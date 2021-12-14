package ru.tadzh;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void startApp() {
        try (ServerSocket serverSocket = new ServerSocket(Common.getPORT())) {
            System.out.println("Server started!");
            RequestParser requestParser = new RequestParser();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new Handler(new Connection(socket), requestParser)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}