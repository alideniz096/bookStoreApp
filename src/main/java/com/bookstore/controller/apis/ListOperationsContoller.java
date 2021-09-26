package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.model.Category;
import com.bookstore.service.ListOperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class ListOperationsContoller {

    private final ListOperationsService listOperationsService;
    private final Logger logger = LoggerFactory.getLogger(ListOperationsContoller.class);

    public ListOperationsContoller(ListOperationsService listOperationsService) {
        this.listOperationsService = listOperationsService;
    }

    /**
     * This api returns all categories in database
     *
     * @return all categories in database as list
     */
    @GetMapping(value = "/listAllCategories")
    public @ResponseBody
    List<Category> listAllCategories() {
        logger.info("ListOperationsContoller - listAllCategories api called");
        return listOperationsService.listAllCategories();
    }

    /**
     * This api returns all books in database
     *
     * @return all books in database as list
     */
    @GetMapping(value = "/listAllBooks")
    public @ResponseBody
    List<Book> listAllBooks() {
        logger.info("ListOperationsContoller - listAllBooks api called");
        return listOperationsService.listAllBooks();
    }

    /**
     * This api returns all books stores in database
     *
     * @return all bookStores in database as list
     */
    @GetMapping(value = "/listAllBookStores")
    public @ResponseBody
    List<BookStore> listAllBookStores() {
        logger.info("ListOperationsContoller - listAllBookStores api called");
        return listOperationsService.listAllBookStores();
    }

    /**
     * This api returns all book categories in database
     *
     * @param categoryName takes categoryName as String
     * @return list all books which categoryName is same with user input
     */
    @GetMapping(value = "/listAllBookByCategory")
    public @ResponseBody
    List<Book> listAllBooksByCategory(String categoryName) {
        logger.info("ListOperationsContoller - listAllBooksByCategory api called for categoryName:{}", categoryName);
        return listOperationsService.listAllBooksByCategoryName(categoryName);
    }

    /**
     * This api returns all books store names in database
     *
     * @param bookStoreName takes bookStoreName as String
     * @return list all the inventory for specified bookStoreName
     */
    @GetMapping(value = "/listAllBooksByBookStoreName")
    public @ResponseBody
    List<BookStoreInventory> listAllBooksByBookStoreName(String bookStoreName) {
        logger.info("ListOperationsContoller - listAllBooksByBookStoreName api called for bookStoreName:{}", bookStoreName);
        return listOperationsService.listAllBooksByBookStoreName(bookStoreName);
    }
}
