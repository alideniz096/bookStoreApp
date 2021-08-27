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
public class BookStoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookStoreInventoryId;

    private Long bookStoreId;

    private String bookStoreName;

    private Long bookId;

    private String bookName;

    private Long bookQuantity;

    private BigDecimal bookPrice;

    private String bookStoreCity;
}
