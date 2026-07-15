package com.example.mockito;

public class OrderService {

    private final ExternalApi paymentApi;
    private final AuditLogger auditLogger;

    public OrderService(ExternalApi paymentApi, AuditLogger auditLogger) {
        this.paymentApi = paymentApi;
        this.auditLogger = auditLogger;
    }

    public void placeOrder() {
        paymentApi.getData(); // simulate charging payment
        auditLogger.log("Order placed");
    }
}
