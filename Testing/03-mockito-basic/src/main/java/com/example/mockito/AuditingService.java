package com.example.mockito;

public class AuditingService {

    private final AuditLogger auditLogger;

    public AuditingService(AuditLogger auditLogger) {
        this.auditLogger = auditLogger;
    }

    public void performAction(String action) {
        auditLogger.log("Action performed: " + action);
    }
}
