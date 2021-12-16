package ru.tadzh.domain;

import ru.tadzh.Connection;
import ru.tadzh.config.Config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpResponse {
    public HttpResponse() {
    }

    public static HttpResponse.ResponseBuilder createBuilderResponse() {
        return new HttpResponse.ResponseBuilder();
    }

    public static class ResponseBuilder {
        private final HttpResponse httpResponse;

        private ResponseBuilder() {
            this.httpResponse = new HttpResponse();
        }

        public HttpResponse build() {
            return this.httpResponse;
        }
    }

    public void getResponse(HttpRequest httpRequest, Connection connection, Config config) {
        Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());
        StringBuilder response = ResponseConstructor.constructor(config, httpRequest, path);
        try {
            Files.readAllLines(path).forEach(response::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        connection.writeResponse(response.toString());
    }
}
