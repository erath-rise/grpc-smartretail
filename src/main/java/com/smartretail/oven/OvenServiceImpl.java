package com.smartretail.oven;

import com.smartretail.generated.OvenProto;
import com.smartretail.generated.OvenServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OvenServiceImpl extends OvenServiceGrpc.OvenServiceImplBase {
    private static final String ovenDataFile = "src/main/resources/oven_data.csv";
    private static final ArrayList<OvenProto.OvenStatusResponse> ovenStatusList = new ArrayList<>();
    private static Timer timer;

    public OvenServiceImpl() {
        loadOvenData();
        scheduleTimer();
    }


    @Override
    public void getOvenStatus(OvenProto.OvenStatusRequest request, StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
        OvenProto.OvenStatusResponse response = getRandomOvenStatusFromList();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void controlOven(OvenProto.OvenControlRequest request, StreamObserver<OvenProto.OvenControlResponse> responseObserver) {
        boolean isOvenOn = request.getTurnOn();

        if (isOvenOn) {
            System.out.println("Turning oven on...");
        } else {
            System.out.println("Turning oven off...");
        }

        // Simulate the oven delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OvenProto.OvenControlResponse response = OvenProto.OvenControlResponse.newBuilder()
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void monitorOvenStatus(OvenProto.OvenMonitorRequest request, StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
        // Simulate monitor by sending oven status periodically
        int numUpdates = 7;
        for (int i = 0; i < numUpdates; i++) {
            OvenProto.OvenStatusResponse response = getRandomOvenStatusFromList();
            responseObserver.onNext(response);
            try {
                Thread.sleep(1000); // Delay between updates
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }


    @Override
    public StreamObserver<OvenProto.OvenStatusResponse> optimizeEnergy(StreamObserver<OvenProto.OvenControlRequest> responseObserver) {
        return new StreamObserver<OvenProto.OvenStatusResponse>() {
            @Override
            public void onNext(OvenProto.OvenStatusResponse status) {
                // Check if the oven is on and the temperature is above a certain threshold
                if (status.getIsOvenOn() && status.getTemperature() > 200) {
                    // Turn off the oven to save energy
                    OvenProto.OvenControlRequest request = OvenProto.OvenControlRequest.newBuilder()
                            .setTurnOn(false)
                            .build();
                    responseObserver.onNext(request);
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in OptimizeEnergy: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void healthCheck(OvenProto.HealthCheckRequest request, StreamObserver<OvenProto.HealthCheckResponse> responseObserver) {
        OvenProto.HealthCheckResponse response = OvenProto.HealthCheckResponse.newBuilder()
                .setStatus(200)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private OvenProto.OvenStatusResponse getRandomOvenStatusFromList() {
        if (!ovenStatusList.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(ovenStatusList.size());
            return ovenStatusList.get(index);
        }

        // Return a default response if the list is empty
        return OvenProto.OvenStatusResponse.newBuilder()
                .setIsOvenOn(false)
                .setTemperature(0)
                .setBakingTask("")
                .setRemainingTime(0)
                .build();
    }


    private static void loadOvenData() {
        try (BufferedReader br = new BufferedReader(new FileReader(ovenDataFile))) {
            String line;
            br.readLine(); // Skip header line if present

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                boolean isOvenOn = Boolean.parseBoolean(data[0]);
                float temperature = Float.parseFloat(data[1]);
                String bakingTask = data[2];
                int remainingTime = Integer.parseInt(data[3]);

                OvenProto.OvenStatusResponse status = OvenProto.OvenStatusResponse.newBuilder()
                        .setIsOvenOn(isOvenOn)
                        .setTemperature(temperature)
                        .setBakingTask(bakingTask)
                        .setRemainingTime(remainingTime)
                        .build();

                ovenStatusList.add(status);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scheduleTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), 0, 5000);
        // Schedule the task to run every 15 mins (for demonstration purposes, it is set to 5 seconds
    }

    public static class Task extends TimerTask {
        private int index = 0;

        @Override
        public void run() {
            if (index < ovenStatusList.size()) {
                OvenProto.OvenStatusResponse status = ovenStatusList.get(index);
                System.out.println("Oven Status: " + status);
                index++;
            }
        }
    }
}