package com.crud.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    @Column
    private String book_name;
    @Column
    private String author;
    @Column
    private int price;





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
