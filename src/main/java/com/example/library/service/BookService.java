package com.example.library.service;

import com.example.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> getBookById(Integer id);

    Book createBook(Book book);

    Book updateBook(Integer id, Book bookDetails);

    void deleteBook(Integer id);
}
