package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.Category;
import com.bookstore.service.CreateOperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/books")
public class CreateOperationsController {

    private final CreateOperationsService createOperationsService;
    private final Logger logger = LoggerFactory.getLogger(CreateOperationsController.class);

    public CreateOperationsController(CreateOperationsService createOperationsService) {
        this.createOperationsService = createOperationsService;
    }


    /**
     * This api creates a new category
     *
     * @param category Category object for insertion
     * @return given Category object
     */
    @PostMapping("/createCategory")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        logger.info("CreateOperationsController - createCategory api called for categoryId:{}", category.getCategoryId());
        return createOperationsService.createCategory(category);
    }


    /**
     * This api creates a new book
     *
     * @param book Book object for insertion
     * @return given Book object
     */
    @PostMapping(value = "/createBook")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        logger.info("CreateOperationsController - createBook api called for bookId:{}", book.getBookId());
        return createOperationsService.createBook(book);
    }


    /**
     * This api creates a new book store
     *
     * @param bookStore BookStore object for insertion
     * @return given BookStore object
     */
    @PostMapping(value = "/createBookStore")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookStore createBookStore(@RequestBody BookStore bookStore) {
        logger.info("CreateOperationsController - createBookStore api called for bookStoreId:{}", bookStore.getBookStoreId());
        return createOperationsService.createBookStore(bookStore);
    }
}
