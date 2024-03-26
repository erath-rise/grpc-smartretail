package com.smartretail.inventory;

import io.grpc.Server;
import io.grpc.ServerBuilder;


import java.io.IOException;

public class InventoryServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new InventoryServiceImpl())
                .build();

        server.start();

        InventoryServiceRegistrar.registerService("inventory-service", port);

        System.out.println("Inventory Server started, listening on " + port);

        // Shutdown hook to shutdown the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Smart Shelf Server");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}
