package com.my_apps.mybookmongo.service;

import com.my_apps.mybookmongo.model.BookModel;
import com.my_apps.mybookmongo.exception.BookNotFoundException;
import com.my_apps.mybookmongo.repository.BookRepository;
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
    public BookModel addBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    // Update a book
    public BookModel updateBook(Long id, BookModel bookModelDetails) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookModel bookModel = optionalBook.get();
            bookModel.setTitle(bookModelDetails.getTitle());
            bookModel.setAuthor(bookModelDetails.getAuthor());
            bookModel.setPrice(bookModelDetails.getPrice());
            bookModel.setIsbn(bookModelDetails.getIsbn());
            return bookRepository.save(bookModel);
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
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public BookModel getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
    }

    public void deleteAll() {
            bookRepository.deleteAll(); // Example: using Spring Data JPA's deleteAll method
    }
}
