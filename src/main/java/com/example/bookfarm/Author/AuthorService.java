package com.example.bookfarm.Author;

public interface AuthorService {
    public Iterable<Author> getAuthor();
    public Void addNewAuthor(Author author);
    public void removeAuthor(Long id);
}
