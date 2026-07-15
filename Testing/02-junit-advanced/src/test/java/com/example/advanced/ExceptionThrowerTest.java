package com.example.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Exercise 4: Exception Testing
 */
public class ExceptionThrowerTest {

    private final ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    public void testThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                exceptionThrower::throwException
        );

        assertEquals("Invalid argument provided", exception.getMessage());
    }
}
