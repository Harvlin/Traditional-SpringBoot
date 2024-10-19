package com.example.template.dao.impl;

import com.example.template.dao.impl.AuthorDaoImpl;
import com.example.template.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    // Create test method to test if AuthorDaoImpl generates correct action towards database
    @Test
    public void testThatCreateAuthorGeneratesTheCorrectSql() {
        Author author = Author.builder()
                .id(1L)
                .name("Harvlin")
                .age(14)
                .build();
        underTest.create(author);

        verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(author.getId()), eq(author.getName()), eq(author.getAge()));
    }

    @Test
    public void testThatOneGeneratesTheCorrectSql() {
        underTest.findOne(1l);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }
}