package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 1: Configuring a Basic Spring Application.
 * Loads applicationContext.xml, retrieves the bookService bean, and
 * exercises it to confirm the Spring context was configured correctly.
 */
public class Ex1_ConfiguringBasicSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Effective Java");
        bookService.addBook("Clean Code");

        System.out.println("Spring context loaded successfully.");
        System.out.println("Books in library: " + bookService.listBooks());
    }
}
