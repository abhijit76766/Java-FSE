package com.cognizant.customerservice;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/customers/{id}")
    public Object message(@PathVariable String id) {
        return Map.of("service", "customer-service", "customerId", id, "message", "Customer details returned");
    }
}
