package com.bookstore.controller.apis;

import com.bookstore.controller.vo.BookStoreInventoryRequest;
import com.bookstore.service.StorageOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/books")
public class StorageOperationController {

    private final StorageOperationService storageOperationService;

    public StorageOperationController(StorageOperationService storageOperationService) {
        this.storageOperationService = storageOperationService;
    }

    /**
     * contains bookId and bookStoreId
     * we will use it to find bookStore's inventory
     * then we will add book which specified with bookId
     *
     * @param request BookStoreInventoryRequest object
     */
    @PostMapping("/addBookToTheBookStoreInventory")
    @ResponseStatus(value = HttpStatus.OK)
    public void addBookToBookStoreInventory(@RequestBody BookStoreInventoryRequest request) {
        storageOperationService.addBookToTheBookStoreInventory(request);
    }

    /**
     * contains bookId and bookStoreId
     * we will use it to find bookStore's inventory
     * then we will remove the book which specified with bookId
     *
     * @param request BookStoreInventoryRequest object
     */
    @DeleteMapping("/removeBookFromTheBookStoreInventory")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeBookFromTheBookStoreInventory(@RequestBody BookStoreInventoryRequest request) {
        storageOperationService.removeBookFromTheBookStoreInventory(request);
    }
}
