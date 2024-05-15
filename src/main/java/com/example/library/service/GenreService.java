package com.example.library.service;

import com.example.library.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> getAllGenres();

    Optional<Genre> getGenreById(Integer id);

    Genre createGenre(Genre genre);

    Genre updateGenre(Integer id, Genre genreDetails);

    void deleteGenre(Integer id);
}
