package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.Category;
import com.bookstore.service.BookCategoryOrganizerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class BookCategoryOrganizerControllerTest {
    @InjectMocks
    private BookCategoryOrganizerController bookCategoryOrganizerController;

    @Mock
    private BookCategoryOrganizerService bookCategoryOrganizerService;


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

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(bookCategoryOrganizerService.changeBookCategory(book.getBookId(), category.getCategoryId())).thenReturn(book);

        Book actualBook = bookCategoryOrganizerController.changeBookCategory(book.getBookId(), category.getCategoryId());

        Assert.assertEquals(actualBook.getBookCategory(), book.getBookCategory());
    }
}
