package ru.tadzh.domain;

import ru.tadzh.Connection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static ru.tadzh.Common.*;

public class HttpResponse {

    StringBuilder response = new StringBuilder();

    public void getResponse(HttpRequest httpRequest, Connection connection) {
        if (httpRequest.getMethod().equals(GET)) {
            Path path = Paths.get(WWW, httpRequest.getUrl());
            if (!Files.exists(path)) {
                response.append(HTTP_NOT_FOUND + CONTENT_TYPE + NOT_FOUND_H1);
                connection.writeResponse(response.toString());
                return;
            }
            response.append(HTTP_OK + CONTENT_TYPE);
            try {
                Files.readAllLines(path).forEach(response::append);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
            connection.writeResponse(response.toString());
        } else {
            response.append(HTTP_NOT_ALLOWED + CONTENT_TYPE + NOT_ALLOWED_H1);
            connection.writeResponse(response.toString());
        }
    }
}