package com.example.bookfarm.Book;

public interface BookService {

    public Iterable<Book>getBook();
    public Void addNewBook(Book book);
    public void removeBook(Long id);
}
