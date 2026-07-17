package com.cognizant.apigateway;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public Map<String, String> fallback() {
        return Map.of("message", "Downstream service is temporarily unavailable");
    }
}
