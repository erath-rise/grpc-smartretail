package com.smartretail.fridge;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.FridgeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FridgeServiceImpl extends FridgeServiceGrpc.FridgeServiceImplBase {
    private static final String fridgeDataFile = "src/main/resources/fridge_data.csv";
    private List<FridgeProto.FridgeStatusResponse> fridgeStatusList = new ArrayList<>();
    private int currentIndex = 0;

    public FridgeServiceImpl() {
        loadFridgeData();
        scheduleTimer();
    }


    @Override
    public void getFridgeStatus(FridgeProto.FridgeStatusRequest request, StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
        if (!fridgeStatusList.isEmpty()) {
            FridgeProto.FridgeStatusResponse response = fridgeStatusList.get(currentIndex);
            responseObserver.onNext(response);
            currentIndex = (currentIndex + 1) % fridgeStatusList.size();
        } else {
            responseObserver.onNext(FridgeProto.FridgeStatusResponse.getDefaultInstance());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void controlFridge(FridgeProto.FridgeControlRequest request, StreamObserver<FridgeProto.FridgeControlResponse> responseObserver) {
        boolean turnOn = request.getTurnOn();
        System.out.println("Fridge is now " + (turnOn ? "on" : "off"));

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
                boolean isFridgeOn = response.getIsFridgeOn();

                if (temperature > 0 && !isFridgeOn) {
                    FridgeProto.FridgeControlRequest controlRequest = FridgeProto.FridgeControlRequest.newBuilder().setTurnOn(true).build();
                    responseObserver.onNext(controlRequest);
                    System.out.println("Fridge temperature is above 0°C. Turning fridge on.");
                } else if (temperature <= 0 && isFridgeOn) {
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

    public void healthCheck(FridgeProto.HealthCheckRequest request, StreamObserver<FridgeProto.HealthCheckResponse> responseObserver) {
        FridgeProto.HealthCheckResponse response = FridgeProto.HealthCheckResponse.newBuilder()
                .setStatus(200)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void loadFridgeData() {
        try (BufferedReader br = new BufferedReader(new FileReader(fridgeDataFile))) {
            String line;
            br.readLine(); // Skip header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
//                String timestamp = data[0];
                float temperature = Float.parseFloat(data[0]);
                boolean isFridgeOn = Boolean.parseBoolean(data[1]);

                FridgeProto.FridgeStatusResponse status = FridgeProto.FridgeStatusResponse.newBuilder()
                        .setTemperature(temperature)
                        .setIsFridgeOn(isFridgeOn)
                        .build();

                fridgeStatusList.add(status);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scheduleTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!fridgeStatusList.isEmpty()) {
                    FridgeProto.FridgeStatusResponse status = fridgeStatusList.get(currentIndex);
                    System.out.println("Fridge Status: " + status);
                    currentIndex = (currentIndex + 1) % fridgeStatusList.size();
                }
            }
        }, 0, 15000);
    }
}
