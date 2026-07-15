package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 3: Implementing Logging with Spring AOP.
 * Loads applicationContext-aop.xml, which registers ExecutionTimeLoggingAspect.
 * Watch the console: every BookService method call will print an execution-time
 * log line produced entirely by the aspect, with no logging code inside BookService itself.
 */
public class Ex3_AopLoggingDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.addBook("The Pragmatic Programmer");
        bookService.listBooks();
        bookService.findBook("The Pragmatic Programmer");

        System.out.println("Done - check the console output above for execution-time log lines.");
    }
}
