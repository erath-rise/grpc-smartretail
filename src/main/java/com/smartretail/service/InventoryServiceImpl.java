package com.smartretail.service;

import com.smartretail.generated.InventoryProto;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImpl {
    private Map<String, Integer> inventoryData = new HashMap<>();

    public InventoryServiceImpl() {
        // 初始化假数据
        inventoryData.put("apple", 100);
        inventoryData.put("pear", 50);
        inventoryData.put("banana", 200);
        inventoryData.put("orange", 150);
        inventoryData.put("grape", 300);
    }

    public void getInventory(InventoryProto.InventoryRequest request, StreamObserver<InventoryProto.InventoryResponse> responseObserver) {
        String productId = request.getProductId();
        int quantity = inventoryData.getOrDefault(productId, 0);
        InventoryProto.InventoryResponse response = InventoryProto.InventoryResponse.newBuilder().setQuantity(quantity).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public StreamObserver<InventoryProto.InventoryUpdate> updateInventory(StreamObserver<InventoryProto.InventoryUpdateResponse> responseObserver) {
        return new StreamObserver<InventoryProto.InventoryUpdate>() {
            @Override
            public void onNext(InventoryProto.InventoryUpdate value) {
                String productId = value.getProductId();
                int quantity = value.getQuantity();
                inventoryData.put(productId, quantity);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(InventoryProto.InventoryUpdateResponse.newBuilder().build());
                responseObserver.onCompleted();
            }
        };
    }
}
