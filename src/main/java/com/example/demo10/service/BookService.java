package com.example.demo10.service;

import com.example.demo10.dto.BookDto;
import com.example.demo10.model.BookModel;
import com.example.demo10.repository.BookRepository;
import com.example.demo10.utils.BookMapper;
import com.example.demo10.utils.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<BookModel> getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<BookModel> getBookByYear(Integer year) {
        return bookRepository.findByPublicationYear(year);
    }

    public List<BookModel> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<BookModel> getBooksByAuthorStartingWith(String letter) {
        return bookRepository.findByAuthorStartingWith(letter);
    }

    public List<BookModel> getBooksByPublicationYearBefore(Integer given) {
        return bookRepository.findAllByPublicationYearBefore(given);
    }

    public Optional<BookModel> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public BookDto addBook(BookDto bookDto) {
        return bookDto;
    }

    public BookDto updateBook(Long id, BookDto bookDto) {
        BookModel bookById = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        bookById.setTitle(bookDto.getTitle());
        BookModel saveBook = bookRepository.save(bookById);
        return BookMapper.toBookDto(saveBook);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
