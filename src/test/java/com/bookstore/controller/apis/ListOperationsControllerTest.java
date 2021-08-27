package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.model.Category;
import com.bookstore.service.ListOperationsService;
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
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListOperationsControllerTest {
    @InjectMocks
    private ListOperationsContoller listOperationsContoller;

    @Mock
    private ListOperationsService listOperationsService;

    @Test
    public void listAllCategories() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("History");

        List<Category> categories = new ArrayList<>();
        categories.add(category);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(listOperationsService.listAllCategories()).thenReturn(categories);

        List<Category> response = listOperationsContoller.listAllCategories();

        Assert.assertEquals(response.get(0).getCategoryId(), categories.get(0).getCategoryId());
    }

    @Test
    public void listAllBooks() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Lord of the Rings");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        List<Book> books = new ArrayList<>();
        books.add(book);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(listOperationsService.listAllBooks()).thenReturn(books);

        List<Book> response = listOperationsContoller.listAllBooks();

        Assert.assertEquals(response.get(0).getBookId(), books.get(0).getBookId());
    }

    @Test
    public void listAllBookStores() {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("İstanbul");
        bookStore.setBookStoreName("Deniz Book Store");

        List<BookStore> bookStores = new ArrayList<>();
        bookStores.add(bookStore);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(listOperationsService.listAllBookStores()).thenReturn(bookStores);

        List<BookStore> response = listOperationsContoller.listAllBookStores();

        Assert.assertEquals(response.get(0).getBookStoreId(), bookStores.get(0).getBookStoreId());
    }

    @Test
    public void listAllBooksByCategory() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Lord of the Rings");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        List<Book> books = new ArrayList<>();
        books.add(book);

        String bookCategoryName = "Fantasy";

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(listOperationsService.listAllBooksByCategoryName(bookCategoryName)).thenReturn(books);

        List<Book> response = listOperationsContoller.listAllBooksByCategory(bookCategoryName);

        Assert.assertEquals(response.get(0).getBookId(), books.get(0).getBookId());
    }

    @Test
    public void listAllBooksByBookStoreName() {
        BookStoreInventory bookStoreInventory = new BookStoreInventory();
        bookStoreInventory.setBookStoreInventoryId(1L);
        bookStoreInventory.setBookStoreId(1L);
        bookStoreInventory.setBookStoreName("Paper Merch");
        bookStoreInventory.setBookName("Thief");
        bookStoreInventory.setBookPrice(BigDecimal.valueOf(40));
        bookStoreInventory.setBookQuantity(10L);

        List<BookStoreInventory> bookStoreInventories = new ArrayList<>();
        bookStoreInventories.add(bookStoreInventory);

        String bookStoreName = "Deniz Book Store";

        Mockito.when(listOperationsService.listAllBooksByBookStoreName(bookStoreName)).thenReturn(bookStoreInventories);

        List<BookStoreInventory> response = listOperationsContoller.listAllBooksByBookStoreName(bookStoreName);

        Assert.assertEquals(response.get(0).getBookId(), bookStoreInventories.get(0).getBookId());
    }
}
