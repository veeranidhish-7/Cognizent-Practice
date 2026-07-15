package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 6: Configuring Beans with Annotations.
 * Loads applicationContext-annotations.xml, which has no explicit <bean> tags -
 * BookRepository and BookService are discovered purely via @Repository/@Service
 * and wired together via @Autowired.
 */
public class Ex6_AnnotationConfigDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-annotations.xml");

        // Default bean name for a component-scanned class is its class name with a lowercase first letter
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Spring in Action");

        System.out.println("Annotation-based configuration worked - books: " + bookService.listBooks());
    }
}
