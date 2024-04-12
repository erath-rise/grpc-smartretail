package com.smartretail.fridge;

import io.grpc.Server;

import java.io.IOException;

public class FridgeServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50052;
        Server server = io.grpc.ServerBuilder.forPort(port)
                .addService(new FridgeServiceImpl())
                .build();

        server.start();
        System.out.println("Fridge Server started on port " + port);
        server.awaitTermination();
    }
}
