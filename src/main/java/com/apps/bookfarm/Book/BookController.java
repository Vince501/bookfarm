package com.apps.bookfarm.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    Iterable<Book> allBooks (){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    Optional<Book> oneBook (@PathVariable Long id){
        return bookRepository.findById(id);
    }
}
