package ru.tadzh.handler;

import ru.tadzh.config.Config;
import ru.tadzh.domain.HttpRequest;
import ru.tadzh.domain.HttpResponse;
import ru.tadzh.service.ResponseSerializer;
import ru.tadzh.service.SocketService;

import java.util.function.Function;

public class StrategyMethodHandler extends MethodHandler {

    private final Function<HttpRequest, HttpResponse> strategy;

    public StrategyMethodHandler(String method, MethodHandler next,
                                 SocketService socketService, ResponseSerializer responseSerializer, Config config,
                                 Function<HttpRequest, HttpResponse> strategy) {
        super(method, next, socketService, responseSerializer, config);
        this.strategy = strategy;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return strategy.apply(request);
    }
}
