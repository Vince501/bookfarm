package com.example.bookfarm.Author;

import com.example.bookfarm.Author.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository <Author, Long> {
    Optional<Author>findByAuthorName(String name);
}
