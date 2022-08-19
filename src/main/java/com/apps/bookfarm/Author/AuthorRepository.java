package com.apps.bookfarm.Author;

import com.apps.bookfarm.Author.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByPhoneNumber(int phoneNumber);
//All the methods of the JpaRepository interface here
}
