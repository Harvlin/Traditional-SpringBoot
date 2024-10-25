package com.example.template.dao;

import com.example.template.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    void create(Book book);

    Optional<Book> findOne (String isbn);

    List<Book> findMany();

    void delete(String number);

    void fullUpdate(String isbn, Book bookA);
}
