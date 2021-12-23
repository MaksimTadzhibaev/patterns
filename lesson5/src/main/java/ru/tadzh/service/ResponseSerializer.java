package ru.tadzh.service;

import ru.tadzh.domain.HttpResponse;

public interface ResponseSerializer {

    String serialize(HttpResponse response);
}
