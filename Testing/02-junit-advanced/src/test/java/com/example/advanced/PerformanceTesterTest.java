package com.example.advanced;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * Exercise 5: Timeout and Performance Testing
 */
public class PerformanceTesterTest {

    private final PerformanceTester performanceTester = new PerformanceTester();

    @Test
    public void testPerformTask_completesWithinTimeLimit() {
        assertTimeout(Duration.ofMillis(500), () -> performanceTester.performTask());
    }
}
