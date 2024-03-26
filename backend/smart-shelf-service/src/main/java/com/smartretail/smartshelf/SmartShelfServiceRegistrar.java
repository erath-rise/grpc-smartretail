package com.smartretail.smartshelf;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

public class SmartShelfServiceRegistrar {

    public static void registerService(String serviceName, int servicePort) {
        ConsulClient consulClient = new ConsulClient("localhost", 8500);

        NewService newService = new NewService();
        newService.setId(serviceName);
        newService.setName(serviceName);
        newService.setAddress("localhost");
        newService.setPort(servicePort);
        // health check
        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setTcp("localhost:" + servicePort);
        serviceCheck.setInterval("10s");
        newService.setCheck(serviceCheck);



        consulClient.agentServiceRegister(newService);
    }
}
