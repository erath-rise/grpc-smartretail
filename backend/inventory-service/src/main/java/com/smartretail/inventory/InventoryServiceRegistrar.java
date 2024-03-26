package com.smartretail.inventory;


import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

public class InventoryServiceRegistrar {

    public static void registerService(String serviceName, int servicePort) {

        ConsulClient consulClient = new ConsulClient("localhost", 8500);

        NewService service = new NewService();
        service.setId(serviceName);
        service.setName(serviceName);
        service.setPort(servicePort);
        service.setAddress("localhost");

        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setTcp("localhost:" + servicePort);
        serviceCheck.setInterval("10s");
        service.setCheck(serviceCheck);

        consulClient.agentServiceRegister(service);
    }
}
