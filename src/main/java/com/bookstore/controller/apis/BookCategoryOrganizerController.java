package com.bookstore.controller.apis;

import com.bookstore.service.BookCategoryOrganizerService;
import com.bookstore.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/books")
public class BookCategoryOrganizerController {

    private final BookCategoryOrganizerService bookCategoryOrganizerService;

    public BookCategoryOrganizerController(BookCategoryOrganizerService bookCategoryOrganizerService) {
        this.bookCategoryOrganizerService = bookCategoryOrganizerService;
    }

    /**
     *
     * @param bookId book's specified Id
     * @param categoryId category's specified Id
     * @return Book object
     */
    @GetMapping(value = "/changeBookCategory")
    public @ResponseBody
    Book changeBookCategory(@RequestParam Long bookId, @RequestParam Long categoryId) {
        return bookCategoryOrganizerService.changeBookCategory(bookId, categoryId);
    }
}
