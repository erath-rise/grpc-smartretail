package com.smartretail.server;

import com.smartretail.InventoryProto;
import com.smartretail.InventoryServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;


public class InventoryService extends InventoryServiceGrpc.InventoryServiceImplBase {
    private final Map<String, Integer> inventory;

    public InventoryService() {
        inventory = new HashMap<>();
        inventory.put("product1", 100);
        inventory.put("product2", 200);
        inventory.put("product3", 300);
    }

    @Override
    public void getInventory(InventoryProto.GetInventoryRequest request, StreamObserver<InventoryProto.GetInventoryResponse> responseObserver) {
        String productId = request.getProductId();
        int quantity = inventory.getOrDefault(productId, 0);
        InventoryProto.GetInventoryResponse response = InventoryProto.GetInventoryResponse.newBuilder()
                .setProductId(productId)
                .setQuantity(quantity)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public StreamObserver<InventoryProto.UpdateInventoryRequest> updateInventory(StreamObserver<InventoryProto.UpdateInventoryResponse> responseObserver) {
        return new StreamObserver<InventoryProto.UpdateInventoryRequest>() {
            @Override
            public void onNext(InventoryProto.UpdateInventoryRequest request) {
                String productId = request.getProductId();
                int quantity = request.getQuantity();
                inventory.put(productId, quantity);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error updating inventory: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                InventoryProto.UpdateInventoryResponse response = InventoryProto.UpdateInventoryResponse.newBuilder()
                        .setSuccess(true)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}
