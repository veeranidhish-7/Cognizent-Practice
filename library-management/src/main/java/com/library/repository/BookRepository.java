package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 1: repository bean defined in applicationContext.xml.
 * Exercise 6: also annotated with @Repository so it can be picked up by
 * component-scanning (only takes effect in the config that enables it).
 *
 * Kept intentionally simple (in-memory list) since these exercises are about
 * Spring wiring, not persistence - persistence with JPA is covered separately
 * in Exercise 9 (see com.library.boot.Book / com.library.boot.BookRepository).
 */
@Repository
public class BookRepository {

    private final List<String> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(title);
    }

    public List<String> findAllBooks() {
        return books;
    }

    public String findBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
