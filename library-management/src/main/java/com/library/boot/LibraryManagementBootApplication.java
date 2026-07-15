package com.library.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 9: Creating a Spring Boot Application.
 * Entry point for the Boot half of the project. @SpringBootApplication
 * auto-configures Spring Web, Spring Data JPA, and the embedded H2 database
 * based on application.properties, and component-scans com.library.boot
 * (this package) - so it picks up Book, BookRepository, and BookController.
 */
@SpringBootApplication
public class LibraryManagementBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementBootApplication.class, args);
    }
}
