package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        try {
            return bookRepository.save(book);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create Book", e);
        }
    }

    @Override
    public Book updateBook(Integer id, Book bookDetails) {
        try {
            bookDetails.setBookId(id);
            return bookRepository.save(bookDetails);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update Book", e);
        }
    }

    @Override
    public void deleteBook(Integer id) {
        try {
            bookRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete Book", e);
        }
    }
}
