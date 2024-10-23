package com.example.template.dao;
import com.example.template.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    void create(Author author);
    Optional<Author> findOne(long authorId);

    List<Author> findMany();

    void fullUpdate(long id, Author author);
}
