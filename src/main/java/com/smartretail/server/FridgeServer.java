package com.smartretail.server;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

import com.smartretail.serviceImpl.FridgeServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

public class FridgeServer {
    private Server server;
    private void start() throws IOException {
        int port = 50052;
        server = ServerBuilder.forPort(port)
                .addService(new FridgeServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            FridgeServer.this.stop();
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
        System.out.println("Registering service to Consul...");

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        String serviceName = props.getProperty("fridge.service.name");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        int servicePort = Integer.parseInt(props.getProperty("fridge.service.port"));
        String healthCheckInterval = props.getProperty("fridge.service.healthCheckInterval");

        // Get host address
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Create a Consul client
        ConsulClient consulClient = new ConsulClient(consulHost, consulPort);

        // Define service details
        NewService newService = new NewService();
        newService.setId("fridge-service");
        newService.setName(serviceName);
        newService.setAddress(hostAddress);
        newService.setPort(servicePort);

        consulClient.agentServiceRegister(newService);

        System.out.println("Service registered to Consul successfully. Host: " + hostAddress );
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        FridgeServer server = new FridgeServer();
        server.start();
        server.blockUntilShutdown();
    }
}
