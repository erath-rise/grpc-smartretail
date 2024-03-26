package com.smartretail.smartshelf;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SmartShelfServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50052;
        Server server = ServerBuilder.forPort(port)
                .addService(new SmartShelfServiceImpl())
                .build();

        server.start();

        SmartShelfServiceRegistrar.registerService("smart-shelf-service", port);

        System.out.println("Smart Shelf Server started, listening on " + port);

       // Shutdown hook to shutdown the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Smart Shelf Server");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}
