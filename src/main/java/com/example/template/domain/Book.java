package com.example.template.domain;

import lombok.*;
import lombok.extern.java.Log;

@Log
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    // Class that define book's attribute
    private String isbn;
    private String title;
    private Long authorId;

}
