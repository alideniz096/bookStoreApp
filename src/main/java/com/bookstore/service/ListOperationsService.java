package com.bookstore.service;


import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookStoreInventoryRepository;
import com.bookstore.repository.BookStoreRepository;
import com.bookstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListOperationsService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;
    private final BookStoreInventoryRepository bookStoreInventoryRepository;

    public ListOperationsService(CategoryRepository categoryRepository, BookRepository bookRepository, BookStoreRepository bookStoreRepository, BookStoreInventoryRepository bookStoreInventoryRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
        this.bookStoreInventoryRepository = bookStoreInventoryRepository;
    }

    public List<Category> listAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public List<Book> listAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<BookStore> listAllBookStores() {
        return (List<BookStore>) bookStoreRepository.findAll();
    }

    public List<Book> listAllBooksByCategoryName(String categoryName) {
        return bookRepository.findAllByBookCategory(categoryName);
    }

    public List<BookStoreInventory> listAllBooksByBookStoreName(String bookStoreName) {
        return bookStoreInventoryRepository.findByBookStoreName(bookStoreName);
    }
}
