package com.smartretail.fridge;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.FridgeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FridgeServiceImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private static final String fridgeDataFile = "src/main/resources/fridge_data.csv";
    private boolean isFridgeOn = true;


    @Override
    public void getFridgeStatus(FridgeProto.FridgeStatusRequest request, StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
        FridgeProto.FridgeStatusResponse response = FridgeProto.FridgeStatusResponse.newBuilder()
                .setIsFridgeOn(isFridgeOn)
                .setTemperature(getCurrentTemperature())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void controlFridge(FridgeProto.FridgeControlRequest request, StreamObserver<FridgeProto.FridgeControlResponse> responseObserver) {
        isFridgeOn = request.getTurnOn();
        System.out.println("Fridge is now " + (isFridgeOn ? "on" : "off"));

        FridgeProto.FridgeControlResponse response = FridgeProto.FridgeControlResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<FridgeProto.FridgeStatusResponse> reportFridgeStatus(StreamObserver<FridgeProto.FridgeControlRequest> responseObserver) {
        return new StreamObserver<FridgeProto.FridgeStatusResponse>() {
            @Override
            public void onNext(FridgeProto.FridgeStatusResponse response) {
                float temperature = response.getTemperature();

                if (temperature > 0 && !isFridgeOn) {
                    isFridgeOn = true;
                    FridgeProto.FridgeControlRequest controlRequest = FridgeProto.FridgeControlRequest.newBuilder().setTurnOn(true).build();
                    responseObserver.onNext(controlRequest);
                    System.out.println("Fridge temperature is above 0°C. Turning fridge on.");
                } else if (temperature <= 0 && isFridgeOn) {
                    isFridgeOn = false;
                    FridgeProto.FridgeControlRequest controlRequest = FridgeProto.FridgeControlRequest.newBuilder().setTurnOn(false).build();
                    responseObserver.onNext(controlRequest);
                    System.out.println("Fridge temperature is at or below 0°C. Turning fridge off.");
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    private float getCurrentTemperature() {
        // Simulating reading temperature from CSV file every 15 seconds
        try (BufferedReader br = new BufferedReader(new FileReader(fridgeDataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                float temperature = Float.parseFloat(data[0]);
                boolean isOn = Boolean.parseBoolean(data[1]);
                isFridgeOn = isOn;

                System.out.println("Current temperature: " + temperature + "°C, Fridge is " + (isOn ? "on" : "off"));

                TimeUnit.SECONDS.sleep(15);
                return temperature;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
