package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryOrganizerService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public Book changeBookCategory(Long bookId, Long categoryId) {
        Book book = bookRepository.findByBookId(bookId);
        Category category = categoryRepository.findByCategoryId(categoryId);

        book.setBookCategory(category.getCategoryName());

        return bookRepository.save(book);
    }
}
