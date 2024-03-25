package com.example;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;
import com.example.controller.InventoryController;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;


public class InventoryServer {
    public static void main(String[] args) throws Exception {
        ConsulClient consulClient = new ConsulClient("localhost", 8500);

        NewService newService = new NewService();
        newService.setId("inventory-service-1");
        newService.setName("inventory-service");
        newService.setAddress("localhost");
        newService.setPort(9002);
        // health check
        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setTcp("localhost:9002");
        serviceCheck.setInterval("10s");
        newService.setCheck(serviceCheck);

        // Register service with Consul
        consulClient.agentServiceRegister(newService);

        InventoryController controller = new InventoryController();
        Server server = ServerBuilder.forPort(9002)
                .addService(controller)
                .build();

        server.start();
        System.out.println("Server started, listening on " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            consulClient.agentServiceDeregister("inventory-service-1");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}



