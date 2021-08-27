package com.bookstore.repository;


import com.bookstore.model.BookStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookStoreRepository extends CrudRepository<BookStore, Long> {
    Optional<BookStore> findByBookStoreName(String name);
    BookStore findByBookStoreId(Long id);
}
