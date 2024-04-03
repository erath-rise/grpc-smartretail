package com.smartretail.service;

import com.smartretail.generated.ProductProto;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl {
    private Map<String, ProductProto.ProductResponse> productData = new HashMap<>();

    public ProductServiceImpl() {
        productData.put("apple", ProductProto.ProductResponse.newBuilder()
                .setProductId("apple")
                .setName("Pink Lady Apple")
                .setDescription("The apple is a sweet, crisp apple with a dense flesh.")
                .setPrice(2.5)
                .build());

        productData.put("pear", ProductProto.ProductResponse.newBuilder()
                .setProductId("pear")
                .setName("Comice Pear")
                .setDescription("The Comice Pear is a sweet, juicy pear with a buttery texture.")
                .setPrice(3.6)
                .build());

        productData.put("banana", ProductProto.ProductResponse.newBuilder()
                .setProductId("banana")
                .setName("Cavendish Banana")
                .setDescription("The Cavendish Banana is a sweet, creamy banana with a smooth texture.")
                .setPrice(1.5)
                .build());

        productData.put("orange", ProductProto.ProductResponse.newBuilder()
                .setProductId("orange")
                .setName("Navel Orange")
                .setDescription("The Navel Orange is a sweet, juicy orange with a thick skin.")
                .setPrice(2.6)
                .build());

        productData.put("grape", ProductProto.ProductResponse.newBuilder()
                .setProductId("grape")
                .setName("Red Globe Grape")
                .setDescription("The Red Globe Grape is a sweet.")
                .setPrice(3.9)
                .build());
    }

    public void getProduct(ProductProto.ProductRequest request, StreamObserver<ProductProto.ProductResponse> responseObserver) {
        String productId = request.getProductId();
        ProductProto.ProductResponse response = productData.get(productId);
        if (response != null) {
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new RuntimeException("Product not found"));
        }
    }
}
