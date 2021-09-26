package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryOrganizerService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public BookCategoryOrganizerService(CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    public Book changeBookCategory(Long bookId, Long categoryId) {
        Book book = bookRepository.findByBookId(bookId);
        Category category = categoryRepository.findByCategoryId(categoryId);

        book.setBookCategory(category.getCategoryName());

        return bookRepository.save(book);
    }
}
