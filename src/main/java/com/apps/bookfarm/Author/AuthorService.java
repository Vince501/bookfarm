package com.apps.bookfarm.Author;

public interface AuthorService {
    public Iterable<Author> getAuthors();
    public void addNewAuthor(Author author);
    public void removeAuthor(Long id);
}
