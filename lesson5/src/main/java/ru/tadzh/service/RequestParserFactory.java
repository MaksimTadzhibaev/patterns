package ru.tadzh.service;

//@Configuration
public class RequestParserFactory {

    //@Bean
    public static RequestParser createRequestParser() {
        return new RequestParserImpl();
    }
}
