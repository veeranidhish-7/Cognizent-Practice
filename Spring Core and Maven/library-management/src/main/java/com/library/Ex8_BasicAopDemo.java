package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 8: Implementing Basic AOP with Spring.
 * Loads applicationContext-aop-full.xml, which registers BeforeAfterLoggingAspect.
 * Watch the console: each BookService call will print a BEFORE line, then the
 * method runs, then an AFTER line - all produced by the aspect.
 */
public class Ex8_BasicAopDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aop-full.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.addBook("Aspect-Oriented Programming in Spring");
        bookService.listBooks();

        System.out.println("Done - check the console output above for BEFORE/AFTER log lines.");
    }
}
