package com.cognizant.greetservice;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/greet")
    public Object message() {
        return Map.of("service", "greet-service", "message", "Hello World");
    }
}
