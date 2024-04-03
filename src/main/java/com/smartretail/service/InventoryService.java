package com.smartretail.service;

import com.smartretail.generated.InventoryProto;
import com.smartretail.generated.InventoryServiceGrpc;
import io.grpc.stub.StreamObserver;

public class InventoryService extends InventoryServiceGrpc.InventoryServiceImplBase {
    private final InventoryServiceImpl inventoryService = new InventoryServiceImpl();

    @Override
    public void getInventory(InventoryProto.InventoryRequest request, StreamObserver<InventoryProto.InventoryResponse> responseObserver) {
        inventoryService.getInventory(request, responseObserver);
    }

    @Override
    public StreamObserver<InventoryProto.InventoryUpdate> updateInventory(StreamObserver<InventoryProto.InventoryUpdateResponse> responseObserver) {
        return inventoryService.updateInventory(responseObserver);
    }
}
