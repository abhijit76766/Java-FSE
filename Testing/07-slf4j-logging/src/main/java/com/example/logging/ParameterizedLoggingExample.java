package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 2: Parameterized Logging
 *
 * SLF4J's {} placeholders avoid the cost of building the log message
 * (e.g. string concatenation) when the log level is disabled.
 */
public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "Abhijit";
        int userId = 42;

        // single parameter
        logger.info("User {} logged in", userName);

        // multiple parameters
        logger.debug("User {} with id {} performed an action", userName, userId);

        // parameterized logging combined with an exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException ex) {
            logger.error("Failed to compute result for user {}", userName, ex);
        }
    }
}
