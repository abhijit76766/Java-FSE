package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 3: Using Different Appenders
 *
 * With logback.xml configuring both a console and a file appender on
 * the root logger, every log statement below is written to both
 * the console AND to app.log.
 */
public class MultiAppenderLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message - visible in console and app.log");
        logger.info("Info message - visible in console and app.log");
        logger.warn("Warning message - visible in console and app.log");
        logger.error("Error message - visible in console and app.log");
    }
}
