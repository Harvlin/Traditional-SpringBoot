package com.example.template.dao;

import com.example.template.domain.Book;
import java.util.Optional;

public interface BookDao {

    void create(Book book);
    Optional<Book> findOne (String isbn);

}
