package ru.tadzh;

import ru.tadzh.domain.HttpRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

public class Handler implements Runnable {

    private final Connection connection;
    private final RequestParser requestParser;

    public Handler(Connection connection, RequestParser requestParser) {
        this.connection = connection;
        this.requestParser = requestParser;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = connection.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        StringBuilder response = new StringBuilder();
        if (httpRequest.getMethod().equals("GET")) {
            Path path = Paths.get(Common.getWWW(), httpRequest.getUrl());

            if (!Files.exists(path)) {
                response.append("HTTP/1.1 404 NOT_FOUND\n");
                response.append("Content-Type: text/html; charset=utf-8\n");
                response.append("\n");
                response.append("<h1>Файл не найден!</h1>");
                connection.writeResponse(response.toString());
                return;
            }

            response.append("HTTP/1.1 200 OK\n");
            response.append("Content-Type: text/html; charset=utf-8\n");
            response.append("\n");

            try {
                Files.readAllLines(path).forEach(response::append);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
            connection.writeResponse(response.toString());
        } else {
            response.append("HTTP/1.1 405 METHOD_NOT_ALLOWED\n");
            response.append("Content-Type: text/html; charset=utf-8\n");
            response.append("\n");
            response.append("<h1>Метод не поддерживается!</h1>");
            connection.writeResponse(response.toString());
            return;
        }
        try {
            connection.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}

