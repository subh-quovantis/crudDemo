package com.crud.demo.model;

import javax.persistence.*;

@Table
@Entity
public class Books {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column
    private String bookName;
    @Column
    private String author;
    @Column
    private int price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
