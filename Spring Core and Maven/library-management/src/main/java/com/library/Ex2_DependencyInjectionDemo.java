package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 2: Implementing Dependency Injection.
 * Confirms Spring's IoC container wired BookRepository into BookService
 * (via the setter) by exercising behavior that only works if the
 * dependency was actually injected.
 */
public class Ex2_DependencyInjectionDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        // If BookRepository were NOT injected, this would throw a NullPointerException.
        bookService.addBook("Domain-Driven Design");
        String found = bookService.findBook("Domain-Driven Design");

        System.out.println(found != null
                ? "Dependency injection worked - found book: " + found
                : "Something went wrong - BookRepository was not injected correctly.");
    }
}
