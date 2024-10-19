package com.example.template.dao.impl;

import com.example.template.dao.impl.BookDaoImpl;
import com.example.template.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    // Create test method to test if BookDaoImpl generates correct action towards database
    @Test
    public void testThatCreateBookGeneratesTheCorrectSql() {
        Book book = Book.builder()
                .isbn("1234567890")
                .title("The beginning after the end")
                .authorId(1L)
                .build();
        underTest.create(book);

        verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("1234567890"), eq("The beginning after the end"), eq(1L)
        );
    }

    @Test
    public void testThatOneGeneratesTheCorrectSql() {
        underTest.findOne("1234567890");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("1234567890")
        );
    }
}
