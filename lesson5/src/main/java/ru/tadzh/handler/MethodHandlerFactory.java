package ru.tadzh.handler;

import org.reflections.Reflections;
import ru.tadzh.config.Config;
import ru.tadzh.domain.HttpRequest;
import ru.tadzh.domain.HttpResponse;
import ru.tadzh.service.ResponseSerializer;
import ru.tadzh.service.SocketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, Config config) {
        Reflections reflections = new Reflections("com.petrov");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Handler.class);
        List<MethodHandler> handlers = new ArrayList<>();
        Class[] params = {String.class, MethodHandler.class, SocketService.class, ResponseSerializer.class, Config.class};
        MethodHandler handler = new MethodHandler() {
            @Override
            protected HttpResponse handleInternal(HttpRequest request) {
                return null;
            }
        };
        int count = 0;
        try {
            for (Class cls : classSet) {
                if (count == 0) {
                    handler = (MethodHandler) cls.getConstructor(params).newInstance("GET", handler, socketService, responseSerializer, config);
                    handlers.add(handler);
                } else if (count == 1) {
                    handler = (MethodHandler) cls.getConstructor(params).newInstance("POST", handler, socketService, responseSerializer, config);
                    handlers.add(handler);
                } else if (count == 2) {
                    handler = (MethodHandler) cls.getConstructor(params).newInstance("PUT", handler, socketService, responseSerializer, config);
                    handlers.add(handler);
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        handlers.sort((o1, o2) -> {
            if (o1.getClass().getAnnotation(Handler.class).order() > o2.getClass().getAnnotation(Handler.class).order()) {
                return 1;
            } else if (o1.getClass().getAnnotation(Handler.class).order() < o2.getClass().getAnnotation(Handler.class).order()) {
                return -1;
            } else {
                return 0;
            }
        });

        return handlers.get(0);

//        PutMethodHandler putHandler = new PutMethodHandler("PUT", null, socketService, responseSerializer, config);
//        PostMethodHandler postHandler = new PostMethodHandler("POST", putHandler, socketService, responseSerializer, config);
//        return new GetMethodHandler("GET", postHandler, socketService, responseSerializer, config);
    }
}
