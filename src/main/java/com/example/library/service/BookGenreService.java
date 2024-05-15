package com.example.library.service;

import com.example.library.model.BookGenre;

import java.util.List;
import java.util.Optional;

public interface BookGenreService {
    List<BookGenre> getAllBookGenres();

    Optional<BookGenre> getBookGenreById(Integer id);

    BookGenre createBookGenre(BookGenre bookGenre);

    BookGenre updateBookGenre(Integer id, BookGenre bookGenreDetails);

    void deleteBookGenre(Integer id);
}
