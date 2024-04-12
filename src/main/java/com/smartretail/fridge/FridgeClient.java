package com.smartretail.fridge;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.FridgeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class FridgeClient {
    private final ManagedChannel channel;
    private final FridgeServiceGrpc.FridgeServiceStub asyncStub;
    private final FridgeServiceGrpc.FridgeServiceBlockingStub blockingStub;

    public FridgeClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        asyncStub = FridgeServiceGrpc.newStub(channel);
        blockingStub = FridgeServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void getFridgeStatus() {
        FridgeProto.FridgeStatusRequest request = FridgeProto.FridgeStatusRequest.newBuilder().build();
        FridgeProto.FridgeStatusResponse response = blockingStub.getFridgeStatus(request);
        System.out.println("Fridge Status: ");
        System.out.println("  Is Fridge On: " + response.getIsFridgeOn());
        System.out.println("  Temperature: " + response.getTemperature());
    }

    public void controlFridge(boolean turnOn) {
        FridgeProto.FridgeControlRequest request = FridgeProto.FridgeControlRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        FridgeProto.FridgeControlResponse response = blockingStub.controlFridge(request);
        System.out.println("Fridge Control Response: " + response);
    }

    public void reportFridgeStatus(float temperature, boolean isFridgeOn) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<FridgeProto.FridgeStatusResponse> requestObserver = asyncStub.reportFridgeStatus(new StreamObserver<FridgeProto.FridgeControlRequest>() {
            @Override
            public void onNext(FridgeProto.FridgeControlRequest response) {
                System.out.println("Received fridge control response: " + response);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Fridge control completed");
                latch.countDown();
            }
        });

        FridgeProto.FridgeStatusResponse statusUpdate = FridgeProto.FridgeStatusResponse.newBuilder()
                .setTemperature(temperature)
                .setIsFridgeOn(isFridgeOn)
                .build();
        requestObserver.onNext(statusUpdate);

        latch.await();


        FridgeProto.FridgeStatusResponse response = FridgeProto.FridgeStatusResponse.newBuilder()
                .setTemperature(temperature)
                .setIsFridgeOn(isFridgeOn)
                .build();
        requestObserver.onNext(response);
        requestObserver.onCompleted();

        latch.await(5, TimeUnit.SECONDS);
    }
    public static void main(String[] args) throws InterruptedException {
        FridgeClient client = new FridgeClient("localhost", 50052);

        client.getFridgeStatus();
        client.controlFridge(true);
        client.reportFridgeStatus(5, true);

        client.shutdown();

    }
}
