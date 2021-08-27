package com.bookstore.service;


import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.model.BookStore;
import com.bookstore.repository.BookStoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOperationsService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public BookStore createBookStore(BookStore bookStore){
        return bookStoreRepository.save(bookStore);
    }
}
