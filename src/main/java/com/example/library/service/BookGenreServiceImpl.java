package com.example.library.service;

import com.example.library.model.BookGenre;
import com.example.library.repository.BookGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookGenreServiceImpl implements BookGenreService {
    private final BookGenreRepository bookGenreRepository;

    @Autowired
    public BookGenreServiceImpl(BookGenreRepository bookGenreRepository) {
        this.bookGenreRepository = bookGenreRepository;
    }

    @Override
    public List<BookGenre> getAllBookGenres() {
        return bookGenreRepository.findAll();
    }

    @Override
    public Optional<BookGenre> getBookGenreById(Integer id) {
        return bookGenreRepository.findById(id);
    }

    @Override
    public BookGenre createBookGenre(BookGenre bookGenre) {
        try {
            return bookGenreRepository.save(bookGenre);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create BookGenre", e);
        }
    }

    @Override
    public BookGenre updateBookGenre(Integer id, BookGenre bookGenreDetails) {
        try {
            bookGenreDetails.setId(id);
            return bookGenreRepository.save(bookGenreDetails);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update BookGenre", e);
        }
    }

    @Override
    public void deleteBookGenre(Integer id) {
        try {
            bookGenreRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete BookGenre", e);
        }
    }
}
