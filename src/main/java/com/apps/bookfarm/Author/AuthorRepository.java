package com.apps.bookfarm.Author;

import com.apps.bookfarm.Author.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByPhoneNumber(int phoneNumber);
    Optional<Author> findByAuthorName(String name);
//All the methods of the JpaRepository interface here
}
