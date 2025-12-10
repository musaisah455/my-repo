package com.code.myapps.mybook.service;

import com.code.myapps.mybook.exception.BookNotFoundException;
import com.code.myapps.mybook.entity.BookEntity;
import com.code.myapps.mybook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add a book
    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }

    // Update a book
    public BookEntity updateBook(Long id, BookEntity bookDetails) {
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setIsbn(bookDetails.getIsbn());
            return bookRepository.save(book);
        }
        throw new BookNotFoundException("Book not found with id " + id);
    }

    // Delete a book
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException("Book not found with id " + id);
        }
    }

    // Get all books
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    public void deleteAll() {
            bookRepository.deleteAll(); // Example: using Spring Data JPA's deleteAll method
    }
}
