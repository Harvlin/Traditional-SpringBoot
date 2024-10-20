package com.example.template;

import com.example.template.domain.Author;
import com.example.template.domain.Book;

public final class TestDataUtility {

    private TestDataUtility() {

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Harvlin")
                .age(14)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("1234567890")
                .title("The beginning after the end")
                .authorId(1L)
                .build();
    }
}
