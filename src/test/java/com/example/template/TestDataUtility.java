package com.example.template;

import com.example.template.domain.Author;
import com.example.template.domain.Book;

public final class TestDataUtility {

    private TestDataUtility() {

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Harvlin")
                .age(15)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Max")
                .age(15)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("John")
                .age(16)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("1234567890")
                .title("The beginning after the end")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("0987654321")
                .title("ORV")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("Solo Leveling")
                .title("DEF")
                .authorId(1L)
                .build();
    }
}
