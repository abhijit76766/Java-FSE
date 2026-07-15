package com.example.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Exercise 3: Argument Matching
 */
public class ArgumentMatchingTest {

    @Test
    public void testGreetUser_withSpecificArgument() {
        GreetingService mockService = mock(GreetingService.class);
        when(mockService.greet(eq("Abhijit"))).thenReturn("Hello, Abhijit");

        Greeter greeter = new Greeter(mockService);
        String result = greeter.greetUser("Abhijit");

        assertEquals("Hello, Abhijit", result);
        verify(mockService).greet("Abhijit");
    }

    @Test
    public void testGreetUser_withAnyStringMatcher() {
        GreetingService mockService = mock(GreetingService.class);
        when(mockService.greet(anyString())).thenReturn("Hello there");

        Greeter greeter = new Greeter(mockService);
        greeter.greetUser("Whoever");

        verify(mockService).greet(anyString());
    }
}
