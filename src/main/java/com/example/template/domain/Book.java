package com.example.template.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private String isbn;
    private String title;
    private Long authorId;

}
