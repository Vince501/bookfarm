package com.example.bookfarm.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorServiceImpl authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }


    //aggregate root
    @GetMapping("/authors")
    Iterable<Author> allAuthors() {
        return authorService.getAuthor();
    }

    //end ::get-aggregate-root[]

    @GetMapping("/authors/{id}")
    Author oneAuthor (@PathVariable Long id){

        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
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
        return authorRepository.findById(id).map(author ->{
            author.setAuthorName(newAuthor.getAuthorName());
            author.setPhoneNumber(newAuthor.getPhoneNumber());
            return authorRepository.save(newAuthor);
        }).orElseGet(()->{newAuthor.setAuthorId(id);
        return authorRepository.save(newAuthor);
    });

    }
}
