package com.smartretail.mobile_app;

import io.grpc.Server;

import java.io.IOException;

public class MobileAppServer {
    public static void main(String[] args) throws IOException {
        int port = 50053;
        Server server = io.grpc.ServerBuilder.forPort(port)
                .addService(new MobileAppServiceImpl())
                .build();

        server.start();
        System.out.println("Mobile App Server started on port " + port);
        try {
            server.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
