package com.smartretail.fridge;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.FridgeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class FridgeClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8002)
                .usePlaintext()
                .build();

        FridgeServiceGrpc.FridgeServiceBlockingStub blockingStub = FridgeServiceGrpc.newBlockingStub(channel);
        try {
            // Get the status of a fridge
            FridgeProto.FridgeStatusRequest statusRequest = FridgeProto.FridgeStatusRequest.newBuilder().setFridgeId("1").build();
            FridgeProto.FridgeStatusResponse statusResponse = blockingStub.getFridgeStatus(statusRequest);
            System.out.println("Fridge Status: " + statusResponse);

            // Control a fridge
            FridgeProto.ControlFridgeRequest controlRequest = FridgeProto.ControlFridgeRequest.newBuilder().setFridgeId("1").setTurnOn(false).build();
            FridgeProto.ControlFridgeResponse controlResponse = blockingStub.controlFridge(controlRequest);
            System.out.println("Control Fridge: " + controlResponse);

            // Monitor a fridge
            FridgeProto.MonitorFridgeRequest monitorRequest = FridgeProto.MonitorFridgeRequest.newBuilder().setFridgeId("1").build();
            System.out.println("Monitoring Fridge:");
            blockingStub.monitorFridge(monitorRequest).forEachRemaining(System.out::println);

            // Health check
            FridgeProto.HealthCheckRequest healthCheckRequest = FridgeProto.HealthCheckRequest.newBuilder().setServiceName("FridgeService").build();
            FridgeProto.HealthCheckResponse healthCheckResponse = blockingStub.healthCheck(healthCheckRequest).next();
            System.out.println("Health Check: " + healthCheckResponse);

        } finally {
            channel.shutdown();
        }
    }
}
