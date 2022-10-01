package com.example.bookfarm.Author;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Author_ID")
    private Long authorId;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;

    public Author(String authorName, int phoneNumber) {
        this.authorName = authorName;
        this.phoneNumber = phoneNumber;
    }

    public Author() {

    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
