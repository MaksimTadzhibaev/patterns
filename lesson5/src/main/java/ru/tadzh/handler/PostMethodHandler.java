package ru.tadzh.handler;

import ru.tadzh.config.Config;
import ru.tadzh.domain.HttpRequest;
import ru.tadzh.domain.HttpResponse;
import ru.tadzh.domain.ResponseCode;
import ru.tadzh.service.ResponseSerializer;
import ru.tadzh.service.SocketService;

@Handler(order = 1)
public class PostMethodHandler extends MethodHandler {

    public PostMethodHandler(String method, MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        super(method, next, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .withStatus(ResponseCode.OK)
                .withHeader("Content-Type", "text/html; charset=utf-8")
                .withBody("<h1>POST method handled</h1>")
                .build();
    }

}
