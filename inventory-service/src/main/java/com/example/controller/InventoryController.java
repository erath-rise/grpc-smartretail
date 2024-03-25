package com.example.controller;

import com.example.InventoryService;
import com.example.InventoryProto;
import com.example.InventoryServiceGrpc;
import io.grpc.stub.StreamObserver;

public class InventoryController extends InventoryServiceGrpc.InventoryServiceImplBase {
    private InventoryService inventoryService;

    public InventoryController() {
        this.inventoryService = inventoryService;
    }

    @Override
    public void getInventory(InventoryProto.GetInventoryRequest request, StreamObserver<InventoryProto.GetInventoryResponse> responseObserver) {
        String productId = request.getProductId();
        int quantity = inventoryService.getInventory(productId);

        InventoryProto.GetInventoryResponse.Builder builder = InventoryProto.GetInventoryResponse.newBuilder();
        builder.setQuantity(quantity);

        InventoryProto.GetInventoryResponse response = builder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateInventory(InventoryProto.UpdateInventoryRequest request, StreamObserver<InventoryProto.UpdateInventoryResponse> responseObserver) {
        String productId = request.getProductId();
        int quantity = request.getQuantity();

        boolean success = inventoryService.updateInventory(productId, quantity);

        InventoryProto.UpdateInventoryResponse.Builder builder = InventoryProto.UpdateInventoryResponse.newBuilder();
        builder.setSuccess(success);

        InventoryProto.UpdateInventoryResponse response = builder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }























}
