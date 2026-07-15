package com.example.springtest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 1: Basic Unit Test for a Service Method
 *
 * A plain POJO-style unit test - no Spring context needed since
 * CalculatorService has no dependencies.
 */
public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }
}
