package ru.tadzh;

import ru.tadzh.config.Config;
import ru.tadzh.config.ConfigFactory;
import ru.tadzh.handler.MethodHandlerFactory;
import ru.tadzh.handler.RequestHandler;
import ru.tadzh.service.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        Config config = ConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.printf("Server started at port %d!%n", config.getPort());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                SocketService socketService = SocketServiceFactory.createSocketService(socket);
                ResponseSerializer responseSerializer = ResponseSerializerFactory.createResponseSerializer();

                new Thread(new RequestHandler(
                        socketService,
                        RequestParserFactory.createRequestParser(),
                        MethodHandlerFactory.create(socketService, responseSerializer, config))
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
