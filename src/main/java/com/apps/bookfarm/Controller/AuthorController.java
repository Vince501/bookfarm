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
    Iterable<Author> allAuthors (){
        return authorRepository.findAll();
    }
    //end::get-aggregate-root[]

    @GetMapping("/authors/{id}")
    Optional<Author> oneAuthor (@PathVariable Long id){
       return authorRepository.findById(id);
    }

    @GetMapping("/authors/contacts/{phone}")
    List<Author> authorPhone (@PathVariable int phone){
        return authorRepository.findByPhoneNumber(phone);
    }

    @PostMapping("/authors")
    Author newAuthor(@RequestBody Author newAuthor){
        return authorRepository.save(newAuthor);
    }

    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
    }

    @PutMapping("authors/{id}")
    Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id){
        return authorRepository.findById(id).map(author -> {
            author.setAuthorName(newAuthor.getAuthorName());
            author.setPhoneNumber(newAuthor.getPhoneNumber());
            return authorRepository.save(newAuthor);
        }).orElseGet(()->{newAuthor.setAuthorId(id);
        return authorRepository.save(newAuthor);
        });
    }
}
