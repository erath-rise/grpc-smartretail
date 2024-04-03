package com.smartretail.service;

import com.smartretail.generated.OrderProto;
import com.smartretail.generated.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;

public class OrderService extends OrderServiceGrpc.OrderServiceImplBase {
    private OrderServiceImpl orderService = new OrderServiceImpl();

    public void createOrder(OrderProto.OrderRequest request, StreamObserver<OrderProto.OrderResponse> responseObserver) {
        orderService.createOrder(request, responseObserver);
    }
}
