package com.smartretail.fridge;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.FridgeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class FridgeServiceImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private final Map<String, FridgeProto.FridgeStatusResponse> fridgeStatusData = new HashMap<>();

    public FridgeServiceImpl() {
        FridgeProto.FridgeStatusResponse.Builder builder = FridgeProto.FridgeStatusResponse.newBuilder();
        builder.setFridgeId("1");
        builder.setTemperature("-2");
        builder.setIsOn(false);
        fridgeStatusData.put("1", builder.build());

        builder.setFridgeId("2");
        builder.setTemperature("4");
        builder.setIsOn(true);
        fridgeStatusData.put("2", builder.build());

        builder.setFridgeId("3");
        builder.setTemperature("8");
        builder.setIsOn(true);
        fridgeStatusData.put("3", builder.build());
    }

    @Override
    public void getFridgeStatus(FridgeProto.FridgeStatusRequest request, StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
        String fridgeId = request.getFridgeId();
        FridgeProto.FridgeStatusResponse fridgeResponse = fridgeStatusData.get(fridgeId);

        if (fridgeResponse != null) {
            responseObserver.onNext(fridgeResponse);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new RuntimeException("Fridge not found:" + fridgeId));
        }
    }

    @Override
    public void controlFridge(FridgeProto.ControlFridgeRequest request, StreamObserver<FridgeProto.ControlFridgeResponse> responseObserver) {
        String fridgeId = request.getFridgeId();
        boolean turnOn = request.getTurnOn();
        FridgeProto.FridgeStatusResponse status = fridgeStatusData.get(fridgeId);

        if (status != null) {
            FridgeProto.FridgeStatusResponse.Builder builder = FridgeProto.FridgeStatusResponse.newBuilder();
            builder.setFridgeId(fridgeId);
            builder.setTemperature(status.getTemperature());
            builder.setIsOn(turnOn);
            fridgeStatusData.put(fridgeId, builder.build());

            String message = turnOn ? "Fridge turned on" : "Fridge turned off";
            FridgeProto.ControlFridgeResponse response = FridgeProto.ControlFridgeResponse.newBuilder()
                    .setSuccess(message)
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new RuntimeException("Fridge not found:" + fridgeId));
        }
    }

    @Override
    public void monitorFridge(FridgeProto.MonitorFridgeRequest request, StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
        String fridgeId = request.getFridgeId();
        for (int i = 0; i < 5; i++) {
            FridgeProto.FridgeStatusResponse status = fridgeStatusData.get(fridgeId);
            if (status != null) {
                responseObserver.onNext(status);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                responseObserver.onError(new RuntimeException("Fridge not found:" + fridgeId));
            }
        }
        responseObserver.onCompleted();
    }
    @Override
    public void healthCheck(FridgeProto.HealthCheckRequest request, StreamObserver<FridgeProto.HealthCheckResponse> responseObserver) {
        String serviceName = request.getServiceName();

        FridgeProto.HealthCheckResponse response = FridgeProto.HealthCheckResponse.newBuilder()
                .setStatus(1)
                .setMessage("Fridge service " + serviceName + " is healthy.")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
