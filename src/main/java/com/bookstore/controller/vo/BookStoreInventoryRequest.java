package com.bookstore.controller.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStoreInventoryRequest {
    private Long bookStoreId;
    private Long bookId;
}
