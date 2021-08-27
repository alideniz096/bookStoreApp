package com.bookstore.controller.apis;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.model.Category;
import com.bookstore.service.CreateOperationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/books")
public class CreateOperationsController {

    private final CreateOperationsService createOperationsService;

    public CreateOperationsController(CreateOperationsService createOperationsService) {
        this.createOperationsService = createOperationsService;
    }


    /**
     * @param category Category object for insertion
     * @return given Category object
     */
    @PostMapping("/createCategory")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        return createOperationsService.createCategory(category);
    }


    /**
     * @param book Book object for insertion
     * @return given Book object
     */
    @PostMapping(value = "/createBook")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return createOperationsService.createBook(book);
    }


    /**
     * @param bookStore BookStore object for insertion
     * @return given BookStore object
     */
    @PostMapping(value = "/createBookStore")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookStore createBookStore(@RequestBody BookStore bookStore) {
        return createOperationsService.createBookStore(bookStore);
    }
}
