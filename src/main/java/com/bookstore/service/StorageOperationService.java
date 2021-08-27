package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.model.BookStoreInventory;
import com.bookstore.repository.BookRepository;
import com.bookstore.controller.vo.BookStoreInventoryRequest;

import com.bookstore.model.BookStore;

import com.bookstore.repository.BookStoreInventoryRepository;

import com.bookstore.repository.BookStoreRepository;
import com.bookstore.util.enums.PriceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StorageOperationService {

    private static final Long ADD_NEW_ONE_BOOK = 1L;

    @Autowired
    private BookStoreInventoryRepository bookStoreInventoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public BookStoreInventory addBookToTheBookStoreInventory(BookStoreInventoryRequest request) {
        BookStore bookStore = findBookStoreById(request.getBookStoreId());
        Book book = findBookById(request.getBookId());

        BigDecimal priceMultiplier = getCityPriceMultiplier(bookStore);

        if (bookAlreadyExist(request.getBookId(), request.getBookStoreId())) {
            BookStoreInventory existingbookStoreInventory = bookStoreInventoryRepository.findByBookIdAndBookStoreId(request.getBookId(), request.getBookStoreId());
            Long existingQuantity = existingbookStoreInventory.getBookQuantity();
            existingbookStoreInventory.setBookQuantity(existingQuantity + ADD_NEW_ONE_BOOK);
            return bookStoreInventoryRepository.save(existingbookStoreInventory);
        } else {
            BookStoreInventory newBookStoreInventory = new BookStoreInventory();
            newBookStoreInventory.setBookId(book.getBookId());
            newBookStoreInventory.setBookName(book.getBookName());
            newBookStoreInventory.setBookPrice(book.getBookPrice().multiply(priceMultiplier));
            newBookStoreInventory.setBookStoreCity(bookStore.getBookStoreCity());
            newBookStoreInventory.setBookStoreId(bookStore.getBookStoreId());
            newBookStoreInventory.setBookStoreName(bookStore.getBookStoreName());
            newBookStoreInventory.setBookQuantity(1L);
            return bookStoreInventoryRepository.save(newBookStoreInventory);
        }
    }

    public boolean removeBookFromTheBookStoreInventory(BookStoreInventoryRequest request) {
        if (bookAlreadyExist(request.getBookId(), request.getBookStoreId())) {
            BookStoreInventory existingbookStoreInventory = bookStoreInventoryRepository.findByBookIdAndBookStoreId(request.getBookId(), request.getBookStoreId());

            bookStoreInventoryRepository.delete(existingbookStoreInventory.getBookStoreInventoryId());
            return true;
        }
        return false;
    }

    private boolean bookAlreadyExist(Long bookId, Long bookStoreId) {
        return bookStoreInventoryRepository.findByBookIdAndBookStoreId(bookId, bookStoreId) != null;
    }

    private BookStore findBookStoreById(Long bookStoreId){

        return bookStoreRepository.findByBookStoreId(bookStoreId);
    }

    private Book findBookById(Long bookId){

        return bookRepository.findByBookId(bookId);
    }

    private BigDecimal getCityPriceMultiplier(BookStore bookStore){
        PriceEnum priceMultiplier = PriceEnum.valueOf(bookStore.getBookStoreCity());
        return new BigDecimal(priceMultiplier.getValue());
    }
}
