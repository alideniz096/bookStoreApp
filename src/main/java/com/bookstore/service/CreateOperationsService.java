package com.bookstore.service;


import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookStoreRepository;
import com.bookstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOperationsService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;

    public CreateOperationsService(CategoryRepository categoryRepository, BookRepository bookRepository, BookStoreRepository bookStoreRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public BookStore createBookStore(BookStore bookStore) {
        return bookStoreRepository.save(bookStore);
    }
}
