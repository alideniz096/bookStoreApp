package com.bookstore.controller.apis;

import com.bookstore.controller.vo.BookStoreInventoryRequest;
import com.bookstore.service.StorageOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/books")
public class StorageOperationController {

    private final StorageOperationService storageOperationService;
    private final Logger logger = LoggerFactory.getLogger(StorageOperationController.class);

    public StorageOperationController(StorageOperationService storageOperationService) {
        this.storageOperationService = storageOperationService;
    }

    /**
     * This api adds the given book to specified book store's inventory
     * contains bookId and bookStoreId
     * we will use it to find bookStore's inventory
     * then we will add book which specified with bookId
     *
     * @param request BookStoreInventoryRequest object
     */
    @PostMapping("/addBookToTheBookStoreInventory")
    @ResponseStatus(value = HttpStatus.OK)
    public void addBookToBookStoreInventory(@RequestBody BookStoreInventoryRequest request) {
        logger.info("StorageOperationController - addBookToBookStoreInventory api called with request:{}", request);
        storageOperationService.addBookToTheBookStoreInventory(request);
    }

    /**
     * This api removes the given book to specified book store's inventory
     * contains bookId and bookStoreId
     * we will use it to find bookStore's inventory
     * then we will remove the book which specified with bookId
     *
     * @param request BookStoreInventoryRequest object
     */
    @DeleteMapping("/removeBookFromTheBookStoreInventory")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeBookFromTheBookStoreInventory(@RequestBody BookStoreInventoryRequest request) {
        logger.info("StorageOperationController - removeBookFromTheBookStoreInventory api called with request:{}", request);
        storageOperationService.removeBookFromTheBookStoreInventory(request);
    }
}
