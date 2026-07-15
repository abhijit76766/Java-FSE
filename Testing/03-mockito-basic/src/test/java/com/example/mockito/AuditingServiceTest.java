package com.example.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Exercise 4: Handling Void Methods
 * Exercise 7: Handling Void Methods with Exceptions
 */
public class AuditingServiceTest {

    @Test
    public void testPerformAction_logsMessage() {
        AuditLogger mockLogger = mock(AuditLogger.class);
        // stub the void method to do nothing (default behavior, shown explicitly)
        doNothing().when(mockLogger).log(anyString());

        AuditingService service = new AuditingService(mockLogger);
        service.performAction("CREATE_USER");

        verify(mockLogger).log("Action performed: CREATE_USER");
    }

    @Test
    public void testPerformAction_whenLoggerThrows_exceptionPropagates() {
        AuditLogger mockLogger = mock(AuditLogger.class);
        doThrow(new RuntimeException("Logging failed"))
                .when(mockLogger).log(anyString());

        AuditingService service = new AuditingService(mockLogger);

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> service.performAction("DELETE_USER")
        );
        assertEquals("Logging failed", ex.getMessage());
    }
}
