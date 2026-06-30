package com.example.PaymentService.Consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BankRestConsumer {
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    public boolean getBankStatus() {
        List<ServiceInstance> instances = discoveryClient.getInstances("Bank-Service");
        if(instances == null || instances.isEmpty()) {
            return false;
        }

        ServiceInstance instance = instances.get(0);
        String url = instance.getUri() + "/bank-status";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,Boolean.class);
    }
}