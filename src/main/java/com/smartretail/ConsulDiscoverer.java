package com.smartretail;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.health.model.HealthService;

import java.util.List;

public class ConsulDiscoverer {
    public static HealthService getHealthyService(String serviceName) {
        ConsulClient client = new ConsulClient("localhost", 8500);

        QueryParams queryParams = new QueryParams("passing");
        List<HealthService> healthyServices = client.getHealthServices(serviceName, true, queryParams).getValue();

        if (healthyServices.isEmpty()) {
            throw new RuntimeException("No healthy instances found for service:" + serviceName);
        }
        return healthyServices.get(0);
    }
}
