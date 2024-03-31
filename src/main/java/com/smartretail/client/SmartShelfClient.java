package com.smartretail.client;

import com.ecwid.consul.v1.health.model.HealthService;
import com.smartretail.ConsulDiscoverer;
import com.smartretail.SmartShelfProto;
import com.smartretail.SmartShelfServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class SmartShelfClient {
    private final SmartShelfServiceGrpc.SmartShelfServiceBlockingStub blockingStub;

    public SmartShelfClient() {
        HealthService healthyService = ConsulDiscoverer.getHealthyService("smart-shelf-service");
        ManagedChannel channel = ManagedChannelBuilder.forAddress(healthyService.getService().getAddress(), healthyService.getService().getPort())
                .usePlaintext()
                .build();
        blockingStub = SmartShelfServiceGrpc.newBlockingStub(channel);
    }

    public Iterator<SmartShelfProto.GetShelfInfoResponse> getShelfInfo(String shelfId) {
        SmartShelfProto.GetShelfInfoRequest request = SmartShelfProto.GetShelfInfoRequest.newBuilder()
                .setShelfId(shelfId)
                .build();
        return blockingStub.getShelfInfo(request);
    }
}
