package com.smartretail.oven;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class OvenServer {
    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new OvenServiceImpl())
                .build();

        server.start();
        System.out.println("Oven Server started on port " + port);
        server.awaitTermination();
    }
}
