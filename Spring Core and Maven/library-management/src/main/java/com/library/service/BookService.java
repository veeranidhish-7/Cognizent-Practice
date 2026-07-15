package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Exercise 1: service bean defined in applicationContext.xml.
 * Exercise 2: has a setter for BookRepository so Spring can wire it via DI.
 * Exercise 6: also annotated with @Service for annotation-based configuration.
 * Exercise 7: also has a constructor taking BookRepository, so applicationContext-constructor.xml
 * can demonstrate constructor injection as well as setter injection.
 *
 * @Autowired on the setter only takes effect in configs that enable component
 * scanning / annotation config (Exercise 6); it's simply ignored by the plain
 * XML-wired configs used in the other exercises.
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    /** No-arg constructor - required so Spring can instantiate the bean and use setter injection. */
    public BookService() {
    }

    /** Exercise 7: constructor injection. */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /** Exercise 2 / 5 / 7: setter injection. */
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.addBook(title);
    }

    public List<String> listBooks() {
        return bookRepository.findAllBooks();
    }

    public String findBook(String title) {
        return bookRepository.findBookByTitle(title);
    }
}
