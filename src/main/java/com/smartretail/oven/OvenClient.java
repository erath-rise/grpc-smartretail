package com.smartretail.oven;


import com.smartretail.generated.OvenProto;
import com.smartretail.generated.OvenServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class OvenClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        OvenServiceGrpc.OvenServiceBlockingStub blockingStub = OvenServiceGrpc.newBlockingStub(channel);
        OvenServiceGrpc.OvenServiceStub asyncStub = OvenServiceGrpc.newStub(channel);

        // Unary RPC
        OvenProto.OvenStatusRequest request = OvenProto.OvenStatusRequest.newBuilder().build();
        OvenProto.OvenStatusResponse response = blockingStub.getOvenStatus(request);
        System.out.println("Oven Status: " + response);

        // Server streaming RPC
        OvenProto.OvenMonitorRequest monitorRequest = OvenProto.OvenMonitorRequest.newBuilder().build();
        blockingStub.monitorOvenStatus(monitorRequest).forEachRemaining(ovenStatusResponse -> {
            System.out.println("Oven Status: " + ovenStatusResponse);
        });

        // Bidirectional streaming
        StreamObserver<OvenProto.OvenStatusResponse> controlRequestObserver = asyncStub.optimizeEnergy(new StreamObserver<OvenProto.OvenControlRequest>() {
            @Override
            public void onNext(OvenProto.OvenControlRequest response) {
                System.out.println("Received oven status: " + response);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Oven control error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Oven control completed");
            }
        });

        // Send oven status updates to the server
//        for (int i = 0; i < 3; i++) {
//            OvenProto.OvenStatusResponse statusUpdate = OvenProto.OvenStatusResponse.newBuilder()
//                    .setIsOvenOn(true)
//                    .setTemperature(180 + i * 10)
//                    .setBakingTask("Cake")
//                    .setRemainingTime(30 - i * 5)
//                    .build();
//            controlRequestObserver.onNext(statusUpdate);
//            Thread.sleep(1000);
//        }

        controlRequestObserver.onCompleted();

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}