package com.example.library.service;

import com.example.library.model.BookGenre;
import com.example.library.repositoryImpl.BookGenreRepositoryImpl;
import org.springframework.stereotype.Service;


@Service
public class BookGenreService {

    private final BookGenreRepositoryImpl bookGenreRepository;

    public BookGenreService(BookGenreRepositoryImpl bookGenreRepository) {
        this.bookGenreRepository = bookGenreRepository;
    }

    public void save(BookGenre bookGenre) {
        bookGenreRepository.save(bookGenre);
    }

    public void deleteByBookId(int bookId) {
        bookGenreRepository.deleteByBookId(bookId);
    }

    public void deleteByGenreId(int genreId) {
        bookGenreRepository.deleteByGenreId(genreId);
    }
}
