package com.example.bookfarm.Book;

public class BookNotFoundException extends RuntimeException{

    BookNotFoundException(Long id){
        super("Error:Could not find book with id:" +id);
    }
}
