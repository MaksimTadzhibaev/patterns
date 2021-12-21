package ru.tadzh;

import java.io.IOException;

public class WebServer {
    public void startApp() {
        Connection connection = new Connection();
        Handler handler = new Handler();
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}