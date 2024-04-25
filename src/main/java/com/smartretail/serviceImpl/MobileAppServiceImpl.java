package com.smartretail.serviceImpl;

import mobile_app.MobileAppProto;
import mobile_app.MobileAppServiceGrpc;
import oven.OvenProto;
import oven.OvenServiceGrpc;
import fridge.FridgeProto;
import fridge.FridgeServiceGrpc;

import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class MobileAppServiceImpl extends MobileAppServiceGrpc.MobileAppServiceImplBase {
    private final OvenServiceGrpc.OvenServiceBlockingStub ovenBlockingStub;
    private final FridgeServiceGrpc.FridgeServiceBlockingStub fridgeBlockingStub;


    public MobileAppServiceImpl() {
        this.ovenBlockingStub = OvenServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build());
        this.fridgeBlockingStub = FridgeServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build());
    }

    @Override
    public void controlOven(OvenProto.OvenControlRequest request,
                            StreamObserver<OvenProto.OvenControlResponse> responseObserver) {
        OvenProto.OvenControlResponse response = ovenBlockingStub.controlOven(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void controlFridge(FridgeProto.FridgeControlRequest request,
                              StreamObserver<FridgeProto.FridgeControlResponse> responseObserver) {
        FridgeProto.FridgeControlResponse response = fridgeBlockingStub.controlFridge(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void monitorOvenStatus(MobileAppProto.OvenMonitorRequest request,
                                  StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
        OvenProto.OvenMonitorRequest ovenRequest = OvenProto.OvenMonitorRequest.newBuilder().build();
        ovenBlockingStub.monitorOvenStatus(ovenRequest).forEachRemaining(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void monitorFridgeStatus(MobileAppProto.FridgeMonitorRequest request,
                                    StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
        FridgeProto.FridgeStatusRequest fridgeRequest = FridgeProto.FridgeStatusRequest.newBuilder().build();
        fridgeBlockingStub.getFridgeStatus(fridgeRequest);
        responseObserver.onCompleted();
    }

    @Override
    public void healthCheck(MobileAppProto.HealthCheckRequest request,
                            StreamObserver<MobileAppProto.HealthCheckResponse> responseObserver) {
        MobileAppProto.HealthCheckResponse response = MobileAppProto.HealthCheckResponse.newBuilder()
                .setStatus(200)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
