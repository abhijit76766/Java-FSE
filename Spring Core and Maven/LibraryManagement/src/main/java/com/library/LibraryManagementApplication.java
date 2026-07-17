package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        runContext("applicationContext.xml", "XML setter injection");
        runContext("applicationContext-annotations.xml", "Annotation component scan");
        runContext("applicationContext-constructor-setter.xml", "Constructor and setter injection");
    }

    private static void runContext(String configFile, String label) {
        System.out.println("\n--- " + label + " ---");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configFile)) {
            BookService bookService = context.getBean(BookService.class);
            bookService.addBook("Clean Code");
            bookService.addBook("Spring in Action");
            bookService.listBooks().forEach(System.out::println);
        }
    }
}
