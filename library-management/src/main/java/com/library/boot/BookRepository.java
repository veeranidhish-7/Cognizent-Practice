package com.library.boot;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Exercise 9: Creating a Spring Boot Application.
 * Spring Data JPA generates the implementation of this interface at runtime -
 * no repository implementation code needs to be written.
 *
 * Named the same as com.library.repository.BookRepository (from the classic
 * exercises) but lives in a different package, so there's no clash. Spring
 * Boot's component scanning is scoped to com.library.boot by default, so it
 * never sees or interferes with the classic, XML-configured beans.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
