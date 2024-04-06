package com.smartretail.fridge;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class FridgeServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8002;
        Server server = ServerBuilder.forPort(port)
                .addService(new FridgeServiceImpl())
                .build();

        server.start();

        System.out.println("Fridge Server started, listening on " + server.getPort());

        server.awaitTermination();
    }
}
