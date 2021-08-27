package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class BookCategoryOrganizerServiceTest {

    @InjectMocks
    private BookCategoryOrganizerService bookCategoryOrganizerService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void changeBookCategory() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Lord of the Rings");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("History");

        Mockito.when(bookRepository.findByBookId(book.getBookId())).thenReturn(book);
        Mockito.when(categoryRepository.findByCategoryId(category.getCategoryId())).thenReturn(category);
        Mockito.when(bookCategoryOrganizerService.changeBookCategory(book.getBookId(), category.getCategoryId())).thenReturn(book);

        Book actualBook = bookCategoryOrganizerService.changeBookCategory(book.getBookId(), category.getCategoryId());

        Assert.assertEquals(actualBook.getBookCategory(), book.getBookCategory());
    }
}
