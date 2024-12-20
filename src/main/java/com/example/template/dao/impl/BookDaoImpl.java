package com.example.template.dao.impl;

import com.example.template.dao.BookDao;
import com.example.template.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
                            book.getIsbn(), book.getTitle(), book.getAuthorId());
    }

    @Override
    public Optional<Book> findOne(String isbn) {
        List<Book> results = jdbcTemplate.query(
                "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1",
                new BookRowMapper(),
                isbn
        );
        return results.stream().findFirst();
    }

    @Override
    public List<Book> findMany() {
        return jdbcTemplate.query("SELECT isbn, title, author_id FROM books",
                new BookRowMapper()
        );
    }

    @Override
    public void delete(String isbn) {
        jdbcTemplate.update("DELETE FROM books WHERE isbn = ?",
                isbn
        );
    }

    @Override
    public void fullUpdate(String isbn, Book bookA) {
        jdbcTemplate.update("UPDATE books SET isbn = ?, title =  ?, author_id = ? WHERE isbn = ?",
                bookA.getIsbn(), bookA.getTitle(), bookA.getAuthorId(), isbn
        );
    }

    public static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(resultSet.getString("isbn"))
                    .title(resultSet.getString("title"))
                    .authorId(resultSet.getLong("author_id"))
                    .build();
        }
    }
}
