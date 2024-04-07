package com.smartretail.oven;

import com.smartretail.generated.OvenProto;
import com.smartretail.generated.OvenServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class OvenClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8001)
                .usePlaintext()
                .build();

        OvenServiceGrpc.OvenServiceBlockingStub blockingStub = OvenServiceGrpc.newBlockingStub(channel);
        OvenServiceGrpc.OvenServiceStub asyncStub = OvenServiceGrpc.newStub(channel);
        try {
            // Get the status of an oven
            OvenProto.OvenStatusRequest statusRequest = OvenProto.OvenStatusRequest.newBuilder().setOvenId("1").build();
            OvenProto.OvenStatusResponse statusResponse = blockingStub.getOvenStatus(statusRequest);
            System.out.println("Oven Status: " + statusResponse);

            // Control an oven
            OvenProto.OvenControlRequest controlRequest = OvenProto.OvenControlRequest.newBuilder().setOvenId("1").setTurnOn(true).build();
            OvenProto.OvenControlResponse controlResponse = blockingStub.controlOven(controlRequest);
            System.out.println("Control Oven: " + controlResponse);

            // Monitor an oven
            OvenProto.OvenMonitorRequest monitorRequest = OvenProto.OvenMonitorRequest.newBuilder().setOvenId("1").build();
            System.out.println("Monitoring Oven:");
            blockingStub.monitorOven(monitorRequest).forEachRemaining(System.out::println);

            // Optimize an oven (bidirectional streaming)
            CountDownLatch latch = new CountDownLatch(1);

            StreamObserver<OvenProto.OvenStatusResponse> requestObserver = asyncStub.optimizeOven(new StreamObserver<>() {
                @Override
                public void onNext(OvenProto.OvenControlRequest value) {
                    System.out.println("Optimize Oven Response: " + value);
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                    latch.countDown();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Optimize Oven Completed");
                    latch.countDown();
                }
            });

            requestObserver.onNext(OvenProto.OvenStatusResponse.newBuilder().setOvenId("1").setTemperature(200).build());
            requestObserver.onNext(OvenProto.OvenStatusResponse.newBuilder().setOvenId("1").setTemperature(300).build());
            requestObserver.onCompleted();

            latch.await(5, TimeUnit.SECONDS);
        } finally {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
