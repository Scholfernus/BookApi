package com.example.demo10.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BookDto {
    private String title;
    private String author;
    private Integer publicationYear;
}
