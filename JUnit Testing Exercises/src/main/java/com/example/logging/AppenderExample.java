package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 3: Using Different Appenders.
 * The logging behavior itself (console + file appenders) is configured in
 * src/main/resources/logback.xml, so this class just needs to log normally;
 * Logback routes the output to both appenders automatically.
 */
public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message - written to console and file appenders");
        logger.info("Info message - application processing started");
        logger.warn("Warn message - something looks off");
        logger.error("Error message - something failed");

        System.out.println("Done. Check the console output above and the generated app.log file.");
    }
}
