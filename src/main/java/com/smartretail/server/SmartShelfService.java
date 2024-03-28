package com.smartretail.server;

import com.smartretail.SmartShelfProto;
import com.smartretail.SmartShelfServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class SmartShelfService extends SmartShelfServiceGrpc.SmartShelfServiceImplBase {
    private Map<String, Map<String, Integer>> shelfInventory;

    public SmartShelfService() {
        shelfInventory = new HashMap<>();
        Map<String, Integer> shelf1 = new HashMap<>();
        shelf1.put("product1", 10);
        shelf1.put("product2", 20);
        shelfInventory.put("shelf1", shelf1);

        Map<String, Integer> shelf2 = new HashMap<>();
        shelf2.put("product2", 15);
        shelf2.put("product3", 25);
        shelfInventory.put("shelf2", shelf2);
    }

    @Override
    public void getShelfInfo(SmartShelfProto.GetShelfInfoRequest request, StreamObserver<SmartShelfProto.GetShelfInfoResponse> responseObserver) {
        String shelfId = request.getShelfId();
        Map<String, Integer> inventory = shelfInventory.get(shelfId);
        if (inventory != null) {
            for (Map.Entry<String, Integer> entry: inventory.entrySet()) {
                SmartShelfProto.GetShelfInfoResponse response = SmartShelfProto.GetShelfInfoResponse.newBuilder()
                        .setShelfId(shelfId)
                        .setProductId(entry.getKey())
                        .setQuantity(entry.getValue())
                        .build();
                responseObserver.onNext(response);
            }
        }
        responseObserver.onCompleted();
    }




















}
