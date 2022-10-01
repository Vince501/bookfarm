package com.example.bookfarm.Author;

public class AuthorNotFoundException extends RuntimeException {
    AuthorNotFoundException(Long id){
        super("Error:Could not find author with id :" + id);
    }
}
