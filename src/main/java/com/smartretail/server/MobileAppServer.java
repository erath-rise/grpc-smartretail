package com.smartretail.server;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

import com.smartretail.serviceImpl.MobileAppServiceImpl;

import io.grpc.Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

public class MobileAppServer {
    private Server server;

    private void start() throws IOException {
        int port = 50053;
        server = io.grpc.ServerBuilder.forPort(port)
                .addService(new MobileAppServiceImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        // Register server to Consul
        registerToConsul();

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            MobileAppServer.this.stop();
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
        System.out.println("Registering server to Consul...");

        // Extract Consul configuration properties
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Extract Consul configuration properties
        String consulHost = props.getProperty("consul.host");
        int consulPort = Integer.parseInt(props.getProperty("consul.port"));
        String serviceName = props.getProperty("mobile_app.service.name");
        int servicePort = Integer.parseInt(props.getProperty("mobile_app.service.port"));
        String healthCheckInterval = props.getProperty("mobile_app.service.healthCheckInterval");

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
        newService.setId("mobile-app-service");
        newService.setName(serviceName);
        newService.setAddress(hostAddress);
        newService.setPort(servicePort);

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        System.out.println("Registered service to Consul, Host: " + hostAddress);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final MobileAppServer server = new MobileAppServer();
        server.start();
        server.blockUntilShutdown();
    }
}

