package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8119), 0);

        httpServer.createContext("/user", new userHandler()); //inisialisasi menggunakan UserHandler

        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
        System.out.println("connect");

    }

    public static class userHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // POST -> create
            // GET -> read
            // PUT -> update
            // DELETE -> delete
            // CRUD

            if ("GET".equals(exchange.getRequestMethod())) {
                // send something intresting to user
                OutputStream outputStream = exchange.getResponseBody();
                String responseToBeSendBack = SQL.Connection();
                exchange.sendResponseHeaders(200, responseToBeSendBack.length());


                outputStream.write(responseToBeSendBack.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }

    }
}
