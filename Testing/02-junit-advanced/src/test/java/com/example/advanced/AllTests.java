package com.example.advanced;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Exercise 2: Test Suites and Categories
 * Groups related test classes into a single suite.
 */
@Suite
@SelectClasses({
        EvenCheckerTest.class,
        ExceptionThrowerTest.class,
        OrderedTests.class,
        PerformanceTesterTest.class
})
public class AllTests {
}
