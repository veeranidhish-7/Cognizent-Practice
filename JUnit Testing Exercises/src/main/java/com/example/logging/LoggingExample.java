package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 1: Logging Error Messages and Warning Levels.
 * Demonstrates basic SLF4J usage for logging at ERROR and WARN levels.
 */
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Application starting up");
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.debug("This is a debug message (only visible if debug level is enabled)");
    }
}
