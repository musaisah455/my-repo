package com.my_apps.mybookmongo.rest;

import com.my_apps.mybookmongo.model.BookModel;
import com.my_apps.mybookmongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    @Autowired
    private BookService bookService;

    // Add a new book
    @PostMapping
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
        return ResponseEntity.ok(bookService.addBook(bookModel));
    }

    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@PathVariable Long id, @RequestBody BookModel bookModelDetails) {
        return ResponseEntity.ok(bookService.updateBook(id, bookModelDetails));
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllResources() {
        // Logic to delete all resources
        // This might involve calling a service layer method that interacts with a database
        // or other data storage to remove all entries.
        System.out.println("Deleting all resources...");
        bookService.deleteAll();
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}
