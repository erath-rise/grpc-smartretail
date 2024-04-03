package com.smartretail.server;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.smartretail.service.InventoryService;
import com.smartretail.service.OrderService;
import com.smartretail.service.ProductService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class RetailServer {
    Server server;
    private void start() throws IOException {
        int port = 8080;
        server = ServerBuilder.forPort(port)
                .addService(new InventoryService())
                .addService(new ProductService())
                .addService(new OrderService())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            RetailServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void registerToConsul() {
        System.out.println("Registering to Consul...");
        ConsulClient client = new ConsulClient("localhost");
        NewService newService = new NewService();
        newService.setId("retail-server");
        newService.setName("retail-server");
        newService.setAddress("localhost");
        newService.setPort(8080);
        client.agentServiceRegister(newService);
        System.out.println("Register to Consul successfully");
        newService.setCheck(new NewService.Check());
        newService.getCheck().setGrpc("localhost:8080");
        newService.getCheck().setInterval("10s");
        // health check
//        newService.setCheck(new NewService.Check());
//        newService.getCheck().setHttp("http://localhost:8080/health");
//        newService.getCheck().setInterval("10s");

        // Deregister service when server is stopped
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Deregistering from Consul...");
            client.agentServiceDeregister("retail-server");
            System.out.println("Deregistered from Consul");
        }));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final RetailServer server = new RetailServer();
        server.start();
        server.blockUntilShutdown();
    }
}
