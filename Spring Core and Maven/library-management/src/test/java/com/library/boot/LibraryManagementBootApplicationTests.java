package com.library.boot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Exercise 9: "Run the Spring Boot application and test the REST endpoints."
 * This smoke test confirms the full Boot context (web + JPA + H2) starts up
 * cleanly. For hands-on REST testing, run the app and use curl/Postman/the
 * H2 console as described in the README.
 */
@SpringBootTest
class LibraryManagementBootApplicationTests {

    @Test
    void contextLoads() {
        // If the ApplicationContext fails to start, this test fails automatically.
    }
}
