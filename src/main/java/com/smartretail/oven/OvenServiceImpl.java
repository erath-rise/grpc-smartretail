package com.smartretail.oven;

import com.smartretail.generated.OvenProto;
import com.smartretail.generated.OvenServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class OvenServiceImpl extends OvenServiceGrpc.OvenServiceImplBase {
    private final Map<String, OvenProto.OvenStatusResponse> OvenStatusData = new HashMap<>();

    public OvenServiceImpl() {
        OvenProto.OvenStatusResponse.Builder builder = OvenProto.OvenStatusResponse.newBuilder();
        builder.setOvenId("1");
        builder.setTemperature(0);
        builder.setIsOn(false);
        builder.setCurrentTask("Idle");
        builder.setBakingTimeRemaining(10);
        OvenStatusData.put("1", builder.build());

        builder.setOvenId("2");
        builder.setTemperature(180);
        builder.setIsOn(true);
        builder.setCurrentTask("Baking");
        builder.setBakingTimeRemaining(30);
        OvenStatusData.put("2", builder.build());

        builder.setOvenId("3");
        builder.setTemperature(280);
        builder.setIsOn(true);
        builder.setCurrentTask("Baking");
        builder.setBakingTimeRemaining(10);
        OvenStatusData.put("3", builder.build());
    }

    @Override
    public void getOvenStatus(OvenProto.OvenStatusRequest request, StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
        String ovenId = request.getOvenId();
        OvenProto.OvenStatusResponse ovenResponse = OvenStatusData.get(ovenId);

        if (ovenResponse != null) {
            responseObserver.onNext(ovenResponse);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new RuntimeException("Oven not found:" + ovenId));
        }
    }

    @Override
    public void controlOven(OvenProto.OvenControlRequest request, StreamObserver<OvenProto.OvenControlResponse> responseObserver) {
        String ovenId = request.getOvenId();
        boolean turnOn = request.getTurnOn();

        OvenProto.OvenStatusResponse status = OvenStatusData.get(ovenId);
        if (status != null) {
            OvenProto.OvenStatusResponse.Builder builder = OvenProto.OvenStatusResponse.newBuilder();
            builder.setOvenId(ovenId);
            builder.setTemperature(status.getTemperature());
            builder.setIsOn(turnOn);
            builder.setCurrentTask(status.getCurrentTask());
            builder.setBakingTimeRemaining(status.getBakingTimeRemaining());
            OvenStatusData.put(ovenId, builder.build());

            String message = turnOn ? "Oven turned on" : "Oven turned off";
            OvenProto.OvenControlResponse response = OvenProto.OvenControlResponse.newBuilder()
                    .setOvenId(ovenId)
                    .setMessage(message)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new RuntimeException("Oven not found:" + ovenId));
        }
    }

    @Override
    public void monitorOven(OvenProto.OvenMonitorRequest request, StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
        String ovenId = request.getOvenId();

        for (int i = 0; i < 5; i++) { // simulate 5 status updates
            OvenProto.OvenStatusResponse status = OvenStatusData.get(ovenId);
            if (status != null) {
                OvenProto.OvenStatusResponse.Builder builder = OvenProto.OvenStatusResponse.newBuilder();
                builder.setOvenId(ovenId);
                builder.setTemperature(status.getTemperature());
                builder.setIsOn(status.getIsOn());
                builder.setCurrentTask(status.getCurrentTask());
                builder.setBakingTimeRemaining(status.getBakingTimeRemaining() - 1);
                OvenStatusData.put(ovenId, builder.build());

                responseObserver.onNext(builder.build());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                responseObserver.onError(new RuntimeException("Oven not found:" + ovenId));
            }
        }

        responseObserver.onCompleted();
    }


    @Override
    public StreamObserver<OvenProto.OvenStatusResponse> optimizeOven(StreamObserver<OvenProto.OvenControlRequest> responseObserver) {
        return new StreamObserver<OvenProto.OvenStatusResponse>() {
            @Override
            public void onNext(OvenProto.OvenStatusResponse value) {
                String ovenId = value.getOvenId();
                int temperature = value.getTemperature();

                if (temperature > 250) {
                    OvenProto.OvenControlRequest request = OvenProto.OvenControlRequest.newBuilder()
                            .setOvenId(ovenId)
                            .setTurnOn(false)
                            .build();
                    responseObserver.onNext(request);
                }
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void healthCheck(OvenProto.HealthCheckRequest request, StreamObserver<OvenProto.HealthCheckResponse> responseObserver) {
        String serviceName = request.getServiceName();

        OvenProto.HealthCheckResponse response = OvenProto.HealthCheckResponse.newBuilder()
                .setStatus(1)
                .setMessage("Oven service " + serviceName + " is healthy.")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
