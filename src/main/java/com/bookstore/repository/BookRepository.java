package com.bookstore.repository;


import com.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByBookName(String name);

    Book findByBookId(Long bookId);

    List<Book> findAllByBookCategory(String categoryName);
}
