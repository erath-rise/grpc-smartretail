package com.smartretail.client;

import com.ecwid.consul.v1.health.model.HealthService;
import com.smartretail.ConsulDiscoverer;
import com.smartretail.InventoryProto;
import com.smartretail.InventoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class InventoryClient {
    private final InventoryServiceGrpc.InventoryServiceBlockingStub blockingStub;
    private final InventoryServiceGrpc.InventoryServiceStub asyncStub;

    public InventoryClient() {
        HealthService healthyService = ConsulDiscoverer.getHealthyService("inventory-service");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(healthyService.getService().getAddress(), healthyService.getService().getPort())
                .usePlaintext()
                .build();
        blockingStub = InventoryServiceGrpc.newBlockingStub(channel);
        asyncStub = InventoryServiceGrpc.newStub(channel);
    }

    public InventoryProto.GetInventoryResponse getInventory (String productId) {
        InventoryProto.GetInventoryRequest request = InventoryProto.GetInventoryRequest.newBuilder()
                .setProductId(productId)
                .build();
        return blockingStub.getInventory(request);
    }

    public void updateInventory(Map<String, Integer> updates) throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<InventoryProto.UpdateInventoryRequest> requestObserver = asyncStub.updateInventory(new StreamObserver<InventoryProto.UpdateInventoryResponse>() {
            @Override
            public void onNext(InventoryProto.UpdateInventoryResponse value) {
                if (value.getSuccess()) {
                    System.out.println("Inventory updated successfully");
                } else {
                    System.out.println("Inventory update failed");
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error updating inventory: " + t.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        });

        for (Map.Entry<String, Integer> entry : updates.entrySet()) {
            InventoryProto.UpdateInventoryRequest request = InventoryProto.UpdateInventoryRequest.newBuilder()
                    .setProductId(entry.getKey())
                    .setQuantity(entry.getValue())
                    .build();
            requestObserver.onNext(request);
        }
        requestObserver.onCompleted();

        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.out.println("Time out: updateInventory can not finish within 1 minute");
        }
    }
























}
