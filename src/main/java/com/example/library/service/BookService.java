package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repositoryImpl.BookRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepositoryImpl bookRepository;

    public BookService(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

}