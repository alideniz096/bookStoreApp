package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.Category;
import com.bookstore.service.CreateOperationsService;
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
public class CreateOperationsControllerTest {
    @InjectMocks
    private CreateOperationsController createOperationsController;

    @Mock
    private CreateOperationsService createOperationsService;

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("History");

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(createOperationsService.createCategory(category)).thenReturn(category);

        Category response = createOperationsController.createCategory(category);

        Assert.assertEquals(response.getCategoryId(), category.getCategoryId());
    }

    @Test
    public void createBook() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Witcher");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(createOperationsService.createBook(book)).thenReturn(book);

        Book response = createOperationsController.createBook(book);

        Assert.assertEquals(response.getBookId(), book.getBookId());
    }

    @Test
    public void createBookStore() {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("İstanbul");
        bookStore.setBookStoreName("Deniz Book Store");

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(createOperationsService.createBookStore(bookStore)).thenReturn(bookStore);

        BookStore response = createOperationsController.createBookStore(bookStore);

        Assert.assertEquals(response.getBookStoreId(), bookStore.getBookStoreId());
    }
}
