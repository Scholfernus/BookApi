package com.example.demo10.controller;

import com.example.demo10.dto.BookDto;
import com.example.demo10.model.BookModel;
import com.example.demo10.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        try {
            List<BookModel> allBooks = bookService.getAllBooks();
            return ResponseEntity.ok(allBooks);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookModel>> getBookByAuthor(@PathVariable String author) {
        try {
            List<BookModel> bookByAuthor = bookService.getBookByAuthor(author);
            return ResponseEntity.ok(bookByAuthor);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<BookModel>> getBookByYear(@PathVariable Integer year) {
        try {
            List<BookModel> bookByYear = bookService.getBookByYear(year);
            return ResponseEntity.ok(bookByYear);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("title/{title}")
    public ResponseEntity<List<BookModel>> getBookByTitle(@PathVariable String title) {
        try {
            List<BookModel> bookByTitle = bookService.getBookByTitle(title);
            return ResponseEntity.ok(bookByTitle);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("authorbyletter/{letter}")
    public ResponseEntity<List<BookModel>> getBookByLetter(@PathVariable String letter) {
        try {
            List<BookModel> authorStartingWith = bookService.getBooksByAuthorStartingWith(letter);
            return ResponseEntity.ok(authorStartingWith);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("before/{num}")
    public ResponseEntity<List<BookModel>> getBookBeforeYear(@PathVariable Integer num) {
        try {
            List<BookModel> publicationYearBefore = bookService.getBooksByPublicationYearBefore(num);
            return ResponseEntity.ok(publicationYearBefore);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookModel>> getBookById(@PathVariable Long id) {
        try {
            Optional<BookModel> bookById = bookService.getBookById(id);
            return ResponseEntity.ok(bookById);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
        try {
            BookDto addedBook = bookService.addBook(bookDto);
            return ResponseEntity.ok(addedBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id,
                                              @RequestBody BookDto bookDto) {
        try {
            BookDto updateBook = bookService.updateBook(id, bookDto);
            return ResponseEntity.ok(updateBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<List<BookModel>> deleteById(@PathVariable("id") Long id) {
        try{
            bookService.deleteBookById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.ordinal()).build();
        }
    }
}