package com.example.advanced;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Exercise 3: Test Execution Order
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    public void firstTest() {
        System.out.println("Running firstTest");
    }

    @Test
    @Order(2)
    public void secondTest() {
        System.out.println("Running secondTest");
    }

    @Test
    @Order(3)
    public void thirdTest() {
        System.out.println("Running thirdTest");
    }
}
