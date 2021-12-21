package ru.tadzh;

import ru.tadzh.config.Config;
import ru.tadzh.domain.HttpRequest;
import ru.tadzh.domain.HttpResponse;

import java.io.IOException;
import java.util.Deque;

import static ru.tadzh.Common.*;

public class Handler implements Runnable {

    private final Connection connection;
    private final RequestParser requestParser;
    private final Config config;

    public Handler(Connection connection, RequestParser requestParser, Config config) {
        this.connection = connection;
        this.requestParser = requestParser;
        this.config = config;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = connection.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);
        HttpResponse.createBuilderResponse().build().getResponse(httpRequest, connection, config);
        try {
            connection.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println(CLIENT_DISCONNECTED);
    }
}

