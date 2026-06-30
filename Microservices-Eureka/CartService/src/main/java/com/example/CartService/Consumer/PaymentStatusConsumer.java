package com.example.CartService.Consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentStatusConsumer {
    @Autowired
    private DiscoveryClient discoveryClient;

    public String getPaymentStatus() {
        List<ServiceInstance> instances = discoveryClient.getInstances("Payment-Service");
        if(instances == null || instances.isEmpty()) {
            return "Failed";
        }
        ServiceInstance instance = instances.get(0);
        String url = instance.getUri() + "/payment-status";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
