package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Exercise 7: Implementing Constructor and Setter Injection.
 * Loads applicationContext-constructor.xml, which defines two BookService
 * beans - one wired via the constructor, one wired via the setter - to
 * verify both injection styles work correctly.
 */
public class Ex7_ConstructorAndSetterInjectionDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-constructor.xml");

        BookService constructorInjected = context.getBean("bookServiceConstructorInjected", BookService.class);
        BookService setterInjected = context.getBean("bookServiceSetterInjected", BookService.class);

        constructorInjected.addBook("Constructor-Injected Book");
        setterInjected.addBook("Setter-Injected Book");

        System.out.println("Constructor injection result: " + constructorInjected.listBooks());
        System.out.println("Setter injection result: " + setterInjected.listBooks());
    }
}
