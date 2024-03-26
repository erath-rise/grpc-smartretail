package com.smartretail.smartshelf;

import com.smartretail.SmartShelfProto;
import com.smartretail.SmartShelfServiceGrpc;
import com.smartretail.InventoryProto;
import com.smartretail.InventoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class SmartShelfServiceImpl extends SmartShelfServiceGrpc.SmartShelfServiceImplBase {
    private final Map<String, Map<String, Integer>> shelfInventory;
    private final ManagedChannel channel;
    private final InventoryServiceGrpc.InventoryServiceStub asyncStub;

    public SmartShelfServiceImpl() {
        this("localhost", 50051);
    }

    public SmartShelfServiceImpl(String host, int port) {
        shelfInventory = new HashMap<>();
        Map<String, Integer> shelf1 = new HashMap<>();
        shelf1.put("product1", 10);
        shelf1.put("product2", 5);
        shelfInventory.put("shelf1", shelf1);

        Map<String, Integer> shelf2 = new HashMap<>();
        shelf2.put("product2", 20);
        shelf2.put("product3", 15);
        shelfInventory.put("shelf2", shelf2);

        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        this.asyncStub = InventoryServiceGrpc.newStub(channel);
    }

    @Override
    public void getShelfInfo(SmartShelfProto.GetShelfInfoRequest request, StreamObserver<SmartShelfProto.GetShelfInfoResponse> responseObserver) {
        for (Map.Entry<String, Map<String, Integer>> shelfEntry: shelfInventory.entrySet()) {
            String shelfId = shelfEntry.getKey();
            Map<String, Integer> inventory = shelfEntry.getValue();
            for (Map.Entry<String, Integer> productEntry : inventory.entrySet()) {
                SmartShelfProto.GetShelfInfoResponse response = SmartShelfProto.GetShelfInfoResponse.newBuilder()
                        .setShelfId(shelfId)
                        .setProductId(productEntry.getKey())
                        .setQuantity(productEntry.getValue())
                        .build();
                responseObserver.onNext(response);
            }
        }
        responseObserver.onCompleted();
    }

    public void updateShelfInfo(SmartShelfProto.UpdateShelfInfoRequest request, StreamObserver<SmartShelfProto.UpdateShelfInfoResponse> responseObserver) {

        String shelfId = request.getShelfId();
        String productId = request.getProductId();
        int quantity = request.getQuantity();

        Map<String, Integer> inventory = shelfInventory.computeIfAbsent(shelfId, k -> new HashMap<>());
        int prevQuantity = inventory.getOrDefault(productId, 0);
        inventory.put(productId, quantity);

        asyncStub.updateInventory(
                InventoryProto.UpdateInventoryRequest.newBuilder()
                        .setProductId(productId)
                        .setQuantity(quantity - prevQuantity)
                        .build(),
                new StreamObserver<InventoryProto.UpdateInventoryResponse>() {
                    @Override
                    public void onNext(InventoryProto.UpdateInventoryResponse updateInventoryResponse) {
                        System.out.println("Inventory updated for product: " + productId);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error updating inventory for product: " + productId);
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Inventory update completed for product: " + productId);
                    }
                }

        );
    }
}
