package com.example.springtest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 9: Parameterized Test with JUnit
 */
public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "0, 0, 0",
            "-1, 1, 0",
            "10, 20, 30"
    })
    public void testAdd_withMultipleInputs(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
