package com.apps.bookfarm;


import com.apps.bookfarm.Author.Author;
import com.apps.bookfarm.Author.AuthorRepository;
import com.apps.bookfarm.Book.Book;
import com.apps.bookfarm.Book.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    public static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase (AuthorRepository authorRepository, BookRepository bookRepository){
        return args -> {

            Author authorOne = new Author();
            authorOne.setAuthorName("Sam Jackson");
            authorOne.setPhoneNumber(12345);
            Author authorTwo = new Author("Emily Jefferson", 2468);

            //save new authors
            authorRepository.save(new Author("Mike Wallace", 23456));
            authorRepository.save(authorOne);
            authorRepository.save(new Author("John Mutiso", 3579));

            bookRepository.save(new Book("Programming 101",
                    authorOne,
                    "MacMilan",
                    123456,
                    245,
                    "Programming, IT, Coding"));
            //Log the author entry
            authorRepository.findAll().forEach(author -> log.info("Preloaded Author: " + author));
            bookRepository.findAll().forEach(book -> log.info("Preloaded Book: " + book));
        };
    }

}
