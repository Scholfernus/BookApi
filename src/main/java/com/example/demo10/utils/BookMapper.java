package com.example.demo10.utils;

import com.example.demo10.dto.BookDto;
import com.example.demo10.model.BookModel;

public class BookMapper {
    public static BookModel toBookModel(BookDto bookDto) {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(bookDto.getTitle());
        bookModel.setAuthor(bookDto.getAuthor());
        bookModel.setPublicationYear(bookDto.getPublicationYear());
        return bookModel;
    }

    public static BookDto toBookDto(BookModel bookModel) {
        BookDto bookDto = new BookDto();
        bookDto.setTitle(bookModel.getTitle());
        bookDto.setAuthor(bookModel.getAuthor());
        bookDto.setPublicationYear(bookModel.getPublicationYear());
        return bookDto;
    }
}
