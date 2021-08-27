package com.bookstore.service;


import com.bookstore.model.Book;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.model.BookStore;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookStoreInventoryRepository;
import com.bookstore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListOperationsService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Autowired
    private BookStoreInventoryRepository bookStoreInventoryRepository;

    public List<Category> listAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }

    public List<Book> listAllBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    public List<BookStore> listAllBookStores(){
        return (List<BookStore>) bookStoreRepository.findAll();
    }

    public List<Book> listAllBooksByCategoryName(String categoryName){
        return bookRepository.findAllByBookCategory(categoryName);
    }

    public List<BookStoreInventory> listAllBooksByBookStoreName(String bookStoreName){
        return bookStoreInventoryRepository.findByBookStoreName(bookStoreName);
    }
}
