package com.okta.mongodb.springbootmongodbdocker.controller;

import com.okta.mongodb.springbootmongodbdocker.dao.BookRepository;
import com.okta.mongodb.springbootmongodbdocker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository repository;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(repository.save(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Integer bookId)
            throws ResourceNotFoundException {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Integer bookId, @RequestBody Book bookDetails) {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
        book.setName(bookDetails.getName());
        book.setAuthorName(bookDetails.getAuthorName());
        return ResponseEntity.ok().body(repository.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable(value = "id") Integer bookId)
            throws ResourceNotFoundException {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
        repository.delete(book);
        return ResponseEntity.ok().body("Book with Id ::[" + bookId + "] deleted");
    }

}
