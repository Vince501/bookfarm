package com.apps.bookfarm.Controller;

import com.apps.bookfarm.Model.Author;
import com.apps.bookfarm.Repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //Aggregate root
    @GetMapping("/authors")
    List<Author> allAuthors (){
        return authorRepository.findAll();
    }
    //end::get-aggregate-root[]

    @GetMapping("/authors/{id}")
    Optional<Author> oneAuthor (@PathVariable Long id){
       return authorRepository.findById(id);
    }

    @PostMapping("/authors")
    Author newAuthor(@RequestBody Author newAuthor){
        return authorRepository.save(newAuthor);
    }


}
