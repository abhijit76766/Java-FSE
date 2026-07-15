package com.example.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures,
 * Setup and Teardown Methods.
 *
 * JUnit 5 replaces JUnit 4's @Before/@After with @BeforeEach/@AfterEach.
 */
public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // runs before every test - creates a fresh fixture
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        // runs after every test - releases the fixture
        calculator = null;
    }

    @Test
    public void testAdd_usingAAAPattern() {
        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testDivide_usingAAAPattern() {
        // Arrange
        int dividend = 10;
        int divisor = 2;

        // Act
        int result = calculator.divide(dividend, divisor);

        // Assert
        assertEquals(5, result);
    }
}
