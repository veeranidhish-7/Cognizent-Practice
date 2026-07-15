package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 5: Configuring the Spring IoC Container.
 * Demonstrates that applicationContext.xml acts as the single, central place
 * where all beans and their dependencies for the application are defined -
 * the IoC container reads this file once and manages the full object graph.
 */
public class Ex5_IoCContainerDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Beans registered in the IoC container: "
                + java.util.Arrays.toString(context.getBeanDefinitionNames()));

        BookService bookService = context.getBean(BookService.class);
        bookService.addBook("Refactoring");
        System.out.println("Books in library: " + bookService.listBooks());
    }
}
