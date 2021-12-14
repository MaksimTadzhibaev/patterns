package ru.tadzh;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static ru.tadzh.Common.*;

public class WebServer {

    public static void startApp() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println(SERVER_STARTED);
            RequestParser requestParser = new RequestParser();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(NEW_CLIENT_CONNECTED);

                new Thread(new Handler(new Connection(socket), requestParser)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}