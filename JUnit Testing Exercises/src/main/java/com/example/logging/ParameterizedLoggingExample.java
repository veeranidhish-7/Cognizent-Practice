package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 2: Parameterized Logging.
 * Demonstrates SLF4J's {} placeholder syntax, which avoids the cost of
 * string concatenation when the log level is disabled.
 */
public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "jdoe";
        int loginAttempt = 3;

        // Single parameter
        logger.info("User {} logged in", username);

        // Multiple parameters
        logger.warn("User {} failed login attempt number {}", username, loginAttempt);

        // Parameterized logging with an exception (exception goes last, not as a placeholder)
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Failed to process request for user {}", username, e);
        }
    }
}
