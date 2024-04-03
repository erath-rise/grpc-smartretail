package com.smartretail.service;

import com.smartretail.generated.OrderProto;
import com.smartretail.generated.ProductProto;
import com.smartretail.generated.ProductServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderServiceImpl {
    private final ProductServiceGrpc.ProductServiceBlockingStub productStub;
    private Map<String, List<OrderProto.OrderItem>> orderData = new HashMap<>();

    public OrderServiceImpl() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        productStub = ProductServiceGrpc.newBlockingStub(channel);
    }

    public void createOrder(OrderProto.OrderRequest request, StreamObserver<OrderProto.OrderResponse> responseObserver) {
        String userId = request.getUserId();
        String orderId = UUID.randomUUID().toString();
        List<OrderProto.OrderItem> orderItems = request.getItemsList();
        double totalPrice = 0.0;
        for (OrderProto.OrderItem orderItem : orderItems) {
            ProductProto.ProductRequest productRequest = ProductProto.ProductRequest.newBuilder()
                    .setProductId(orderItem.getProductId())
                    .build();
            ProductProto.ProductResponse productResponse = productStub.getProduct(productRequest);

            totalPrice += productResponse.getPrice() * orderItem.getQuantity();
        }

        orderData.put(orderId, orderItems);
        OrderProto.OrderResponse response = OrderProto.OrderResponse.newBuilder()
                .setOrderId(orderId)
                .setStatus("Order created")
                .setTotalPrice(totalPrice)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    public void getProductInfo(ProductProto.ProductRequest request, StreamObserver<ProductProto.ProductResponse> responseObserver) {
        ProductProto.ProductResponse response = productStub.getProduct(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
