package ru.tadzh.domain;

import ru.tadzh.config.Config;

import java.nio.file.Files;
import java.nio.file.Path;

import static ru.tadzh.Common.*;

public class ResponseConstructor {

    public static StringBuilder constructor(Config config, HttpRequest httpRequest, Path path) {
        StringBuilder response = new StringBuilder();
        if (!Files.exists(path)) {
            response.append(HTTP_NOT_FOUND + CONTENT_TYPE + NOT_FOUND_H1);
        } else
            switch (httpRequest.getMethod()) {
                case GET:
                    response.append(HTTP_OK + CONTENT_TYPE);
                    break;
                case POST:
                    // TODO: 16.12.2021
                    break;
                case PUT:
                    // TODO: 16.12.2021
                    break;
                default:
                    response.append(HTTP_NOT_ALLOWED + CONTENT_TYPE + NOT_ALLOWED_H1);
                    break;
            }
        return response;
    }
}

