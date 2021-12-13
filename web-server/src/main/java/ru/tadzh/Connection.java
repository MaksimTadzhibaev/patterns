package ru.tadzh;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
    private final Handler handler;

    public Connection() {
        handler = new Handler();
    }

    public void connect() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(Common.getPORT())) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
                new Thread(() -> handler.handleRequest(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
