package com.example.demo;


import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.dao.EmptyResultDataAccessException;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {
    private final BookRepository repo;
    
    public BookController(BookRepository repo) {
        this.repo = repo;
    }
    
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            log.debug("Adding new book: {}", book);
            Book savedBook = repo.save(book);
            log.debug("Book saved successfully: {}", savedBook);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (Exception e) {
            log.error("Error adding book: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                              .body(null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        try {
            log.debug("Deleting book with ID: {}", id);
            repo.deleteById(id);
            log.debug("Book deleted successfully");
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            log.error("Book with ID {} not found", id);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error deleting book with ID {}: ", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return repo.findById(id)
            .map(book -> {
                book.setName(updatedBook.getName());
                book.setDescription(updatedBook.getDescription());
                book.setRating(updatedBook.getRating());
                Book savedBook = repo.save(book);
                return ResponseEntity.ok(savedBook);
            })
            .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

}