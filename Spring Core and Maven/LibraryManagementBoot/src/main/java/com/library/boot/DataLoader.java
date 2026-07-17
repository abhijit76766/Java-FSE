package com.library.boot;

import com.library.boot.entity.Book;
import com.library.boot.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.save(new Book("Clean Code", "Robert C. Martin"));
        bookRepository.save(new Book("Spring in Action", "Craig Walls"));
    }
}
