package com.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookStoreId;

    private String bookStoreCity;

    private String bookStoreName;

    public BookStore() {
    }

    public BookStore(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }
}

