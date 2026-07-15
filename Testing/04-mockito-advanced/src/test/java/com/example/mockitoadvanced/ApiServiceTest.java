package com.example.mockitoadvanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Exercise 2: Mocking External Services (RESTful APIs)
 */
public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        RestClient mockRestClient = mock(RestClient.class);
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
    }
}
