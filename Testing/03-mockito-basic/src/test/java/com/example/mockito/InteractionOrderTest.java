package com.example.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

/**
 * Exercise 6: Verifying Interaction Order
 */
public class InteractionOrderTest {

    @Test
    public void testPlaceOrder_callsPaymentBeforeLogging() {
        ExternalApi mockPaymentApi = mock(ExternalApi.class);
        AuditLogger mockAuditLogger = mock(AuditLogger.class);

        OrderService orderService = new OrderService(mockPaymentApi, mockAuditLogger);
        orderService.placeOrder();

        InOrder inOrder = inOrder(mockPaymentApi, mockAuditLogger);
        inOrder.verify(mockPaymentApi).getData();
        inOrder.verify(mockAuditLogger).log("Order placed");
    }
}
