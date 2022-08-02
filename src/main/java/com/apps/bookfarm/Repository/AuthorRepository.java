package com.apps.bookfarm.Repository;

import com.apps.bookfarm.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author, Long> {

}
