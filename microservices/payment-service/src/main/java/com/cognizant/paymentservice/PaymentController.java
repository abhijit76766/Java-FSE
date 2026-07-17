package com.cognizant.paymentservice;

import java.time.Duration;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/{paymentId}/authorize")
    @CircuitBreaker(name = "thirdPartyPayment", fallbackMethod = "fallback")
    public Map<String, String> authorize(@PathVariable String paymentId) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        if (paymentId.startsWith("FAIL")) {
            throw new IllegalStateException("Third-party payment API failed");
        }
        return Map.of("paymentId", paymentId, "status", "AUTHORIZED");
    }

    public Map<String, String> fallback(String paymentId, Throwable error) {
        LOGGER.warn("Payment fallback for {} because {}", paymentId, error.toString());
        return Map.of("paymentId", paymentId, "status", "PENDING_RETRY", "reason", "Fallback executed");
    }
}
