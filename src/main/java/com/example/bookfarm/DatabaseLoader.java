package com.example.bookfarm;

import com.example.bookfarm.Author.Author;
import com.example.bookfarm.Author.AuthorRepository;
import com.example.bookfarm.Book.Book;
import com.example.bookfarm.Book.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    public static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase (AuthorRepository authorRepository, BookRepository bookRepository){
        return args -> {
            Author authorOne = new Author();
            authorOne.setAuthorName("James Bond");
            authorOne.setPhoneNumber(123456);

            Author authorTwo = new Author("Emily John", 245566);
            //save new authors
            authorRepository.save(new Author( "Vincent Mugambi", 34577));
            authorRepository.save(new Author( "Mutungi Vincent", 34539));
            authorRepository.save(new Author( "George Kariuki", 34347));

            authorRepository.save(authorOne);

            bookRepository.save(new Book( "Springboot 101",
                    authorOne,
                    "Moran",
                    123456,
                    245,
                    "IT, coding"
                    ));
            //log the author entry
            authorRepository.findAll().forEach(author -> log.info("Preloaded Author: " + author));
            bookRepository.findAll().forEach(book -> log.info("preload Book:" + book));
        };
    }
}
