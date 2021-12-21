package ru.tadzh;

import ru.tadzh.domain.HttpRequest;
import ru.tadzh.domain.HttpResponse;
import java.io.IOException;
import java.util.Deque;
import static ru.tadzh.Common.*;

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
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.getResponse(httpRequest, connection);
        try {
            connection.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println(CLIENT_DISCONNECTED);
    }
}

