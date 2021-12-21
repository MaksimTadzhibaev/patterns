package ru.tadzh;

import ru.tadzh.config.Config;
import ru.tadzh.config.ConfigFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static ru.tadzh.Common.*;

public class WebServer {

    public static void startApp(String[] args) {
        Config config = ConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println(SERVER_STARTED + " " + config.getPort());
            RequestParser requestParser = new RequestParser();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(NEW_CLIENT_CONNECTED);

                new Thread(new Handler(new Connection(socket), requestParser, config)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}