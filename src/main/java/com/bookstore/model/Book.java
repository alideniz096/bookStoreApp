package com.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookCategory;

    private String bookName;

    private BigDecimal bookPrice;

    public Book() {
    }

    public Book(String bookName, String bookCategory, BigDecimal bookPrice) {
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookPrice = bookPrice;
    }
}
