package com.example.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Exercise 5: Mocking and Stubbing with Multiple Returns
 */
public class MultipleReturnsTest {

    @Test
    public void testFetchData_returnsDifferentValuesOnConsecutiveCalls() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Response")
                .thenReturn("Second Response");

        MyService service = new MyService(mockApi);

        assertEquals("First Response", service.fetchData());
        assertEquals("Second Response", service.fetchData());
    }
}
