package com.apps.bookfarm.Repository;

import com.apps.bookfarm.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
