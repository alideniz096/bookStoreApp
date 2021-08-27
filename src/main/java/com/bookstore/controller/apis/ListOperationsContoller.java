package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.model.Category;
import com.bookstore.service.ListOperationsService;
import com.bookstore.model.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class ListOperationsContoller {
    @Autowired
    private ListOperationsService listOperationsService;

    /**
     *
     * @return all categories in database as list
     */
    @GetMapping(value = "/listAllCategories")
    public @ResponseBody
    List<Category> listAllCategories() {
        return listOperationsService.listAllCategories();
    }

    /**
     *
     * @return all books in database as list
     */
    @GetMapping(value = "/listAllBooks")
    public @ResponseBody
    List<Book> listAllBooks() {
        return listOperationsService.listAllBooks();
    }

    /**
     *
     * @return all bookStores in database as list
     */
    @GetMapping(value = "/listAllBookStores")
    public @ResponseBody
    List<BookStore> listAllBookStores() {
        return listOperationsService.listAllBookStores();
    }

    /**
     *
     * @param categoryName takes categoryName as String
     * @return list all books which categoryName is same with user input
     */
    @GetMapping(value = "/listAllBookByCategory")
    public @ResponseBody
    List<Book> listAllBooksByCategory(String categoryName) {
        return listOperationsService.listAllBooksByCategoryName(categoryName);
    }

    /**
     *
     * @param bookStoreName takes bookStoreName as String
     * @return list all the inventory for specified bookStoreName
     */
    @GetMapping(value = "/listAllBooksByBookStoreName")
    public @ResponseBody
    List<BookStoreInventory> listAllBooksByBookStoreName(String bookStoreName) {
        return listOperationsService.listAllBooksByBookStoreName(bookStoreName);
    }
}
