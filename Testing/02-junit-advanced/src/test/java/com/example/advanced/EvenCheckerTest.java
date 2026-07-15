package com.example.advanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Exercise 1: Parameterized Tests
 */
public class EvenCheckerTest {

    private final EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100})
    public void testIsEven_withEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    public void testIsEven_withOddNumbers(int number) {
        assertTrue(!evenChecker.isEven(number));
    }
}
