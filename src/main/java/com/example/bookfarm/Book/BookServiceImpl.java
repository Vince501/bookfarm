package com.example.bookfarm.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements  BookService {

    private final BookRepository bookRepository;

@Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getBook(){return bookRepository.findAll();}

    @Override
    public Void addNewBook(Book book){

    return null;
    }

    @Override
    public void removeBook(Long id){

    }

}
