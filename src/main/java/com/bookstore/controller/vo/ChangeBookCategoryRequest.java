package com.bookstore.controller.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeBookCategoryRequest {
    Long bookId;
    String bookCategory;
}
