package com.apps.bookfarm.Book;

import com.apps.bookfarm.Author.Author;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private Long bookId;
    @Column(name = "BOOK_TITLE")
    private String title;
    @OneToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    @Column(name = "BOOK_PUBLISHER")
    private String publisher;
    @Column (name = "BOOK_ISBN")
    private int isbn;
    @Column (name = "BOOK_LENGTH")
    private int length;
    @Column (name = "BOOK_SUBJECT")
    private String subjects;

    public Book(String title, Author author, String publisher, int isbn, int length, String subjects) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.length = length;
        this.subjects = subjects;
    }

    public Book() {

    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor (Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher='" + publisher + '\'' +
                ", isbn=" + isbn +
                ", length=" + length +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
