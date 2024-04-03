package com.smartretail.service;

import com.smartretail.generated.ProductProto;
import com.smartretail.generated.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {
    private final ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public void getProduct(ProductProto.ProductRequest request, StreamObserver<ProductProto.ProductResponse> responseObserver) {
        productService.getProduct(request, responseObserver);
    }
}
