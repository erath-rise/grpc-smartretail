package com.smartretail.mobile_app;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.MobileAppProto;
import com.smartretail.generated.MobileAppServiceGrpc;
import com.smartretail.generated.OvenProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class MobileAppClient {
    private final ManagedChannel channel;
    private final MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub;

    public MobileAppClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = MobileAppServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown();
    }

    public void controlOven(boolean turnOn) {
        OvenProto.OvenControlRequest request = OvenProto.OvenControlRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        blockingStub.controlOven(request);
    }

    public void controlFridge(boolean turnOn) {
        FridgeProto.FridgeControlRequest request = FridgeProto.FridgeControlRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        blockingStub.controlFridge(request);
    }

    public Iterator<OvenProto.OvenStatusResponse> monitorOvenStatus() {
        MobileAppProto.OvenMonitorRequest request = MobileAppProto.OvenMonitorRequest.newBuilder().build();
        return blockingStub.monitorOvenStatus(request);
    }

    public Iterator<FridgeProto.FridgeStatusResponse> monitorFridgeStatus() {
        MobileAppProto.FridgeMonitorRequest request = MobileAppProto.FridgeMonitorRequest.newBuilder().build();
        return blockingStub.monitorFridgeStatus(request);
    }

    public static void main(String[] args) throws InterruptedException {
        MobileAppClient client = new MobileAppClient("localhost", 50053);

        // Control oven
        client.controlOven(true);
        System.out.println("Oven turned on");

        // Control fridge
        client.controlFridge(true);
        System.out.println("Fridge turned on");

        // Monitor oven status
        Iterator<OvenProto.OvenStatusResponse> ovenStatusResponses = client.monitorOvenStatus();
        while (ovenStatusResponses.hasNext()) {
            OvenProto.OvenStatusResponse response = ovenStatusResponses.next();
            System.out.println("Oven Status: " + response);
        }

        // Monitor fridge status
        Iterator<FridgeProto.FridgeStatusResponse> fridgeStatusResponses = client.monitorFridgeStatus();
        while (fridgeStatusResponses.hasNext()) {
            FridgeProto.FridgeStatusResponse response = fridgeStatusResponses.next();
            System.out.println("Fridge Status: " + response);
        }

        client.shutdown();
    }
}
