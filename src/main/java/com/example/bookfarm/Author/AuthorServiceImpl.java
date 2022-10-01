package com.example.bookfarm.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

    private  final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }



    @Override
    public Iterable<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Void addNewAuthor(Author author) {

        return null;
    }

    @Override
    public void removeAuthor(Long id) {

    }
}
