package com.cognizant.billingservice;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/billing/{id}")
    public Object message(@PathVariable String id) {
        return Map.of("service", "billing-service", "billingId", id, "message", "Billing details returned");
    }
}
