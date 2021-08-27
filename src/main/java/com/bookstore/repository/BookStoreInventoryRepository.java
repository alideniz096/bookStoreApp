package com.bookstore.repository;

import com.bookstore.model.BookStoreInventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreInventoryRepository extends CrudRepository<BookStoreInventory, Long> {
    List<BookStoreInventory> findByBookStoreName(String bookStoreName);
    BookStoreInventory findByBookIdAndBookStoreId(Long bookId, Long bookStoreId);
}