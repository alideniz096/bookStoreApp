package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.model.Category;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookStoreInventoryRepository;
import com.bookstore.repository.BookStoreRepository;
import com.bookstore.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListOperationServiceTest {
    @InjectMocks
    private ListOperationsService listOperationsService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookStoreRepository bookStoreRepository;

    @Mock
    private BookStoreInventoryRepository bookStoreInventoryRepository;

    @Test
    public void listAllCategories() {
        Category category = new Category();
        category.setCategoryId(1L);
        category.setCategoryName("History");

        List<Category> categories = new ArrayList<>();
        categories.add(category);

        Mockito.when(listOperationsService.listAllCategories()).thenReturn(categories);

        List<Category> actualCategories = listOperationsService.listAllCategories();

        Assert.assertEquals(actualCategories.get(0).getCategoryName(), categories.get(0).getCategoryName());
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

        Mockito.when(listOperationsService.listAllBooks()).thenReturn(books);

        List<Book> actualBooks = listOperationsService.listAllBooks();

        Assert.assertEquals(actualBooks.get(0).getBookName(), books.get(0).getBookName());
    }

    @Test
    public void listAllBookStores() {
        BookStore bookStore = new BookStore();
        bookStore.setBookStoreId(1L);
        bookStore.setBookStoreCity("İstanbul");
        bookStore.setBookStoreName("Deniz Book Store");

        List<BookStore> bookStores = new ArrayList<>();
        bookStores.add(bookStore);

        Mockito.when(listOperationsService.listAllBookStores()).thenReturn(bookStores);

        List<BookStore> actualBookStores = listOperationsService.listAllBookStores();

        Assert.assertEquals(actualBookStores.get(0).getBookStoreName(), bookStores.get(0).getBookStoreName());
    }

    @Test
    public void listAllBooksByCategoryName() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookName("Lord of the Rings");
        book.setBookCategory("Fantasy");
        book.setBookPrice(BigDecimal.valueOf(50));

        List<Book> books = new ArrayList<>();
        books.add(book);

        String bookCategoryName = "Fantasy";

        Mockito.when(listOperationsService.listAllBooksByCategoryName(bookCategoryName)).thenReturn(books);

        List<Book> actualBooks = listOperationsService.listAllBooksByCategoryName(bookCategoryName);

        Assert.assertEquals(actualBooks.get(0).getBookName(), books.get(0).getBookName());
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

        List<BookStoreInventory> actualBookStoreInventory = listOperationsService.listAllBooksByBookStoreName(bookStoreName);

        Assert.assertEquals(actualBookStoreInventory.get(0).getBookName(), bookStoreInventories.get(0).getBookName());
    }
}
