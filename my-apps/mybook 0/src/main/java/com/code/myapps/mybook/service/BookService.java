package com.code.myapps.mybook.service;

import com.code.myapps.mybook.exception.BookNotFoundException;
import com.code.myapps.mybook.model.Book;
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
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update a book
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
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
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    public void deleteAll() {
            bookRepository.deleteAll(); // Example: using Spring Data JPA's deleteAll method
    }
}
