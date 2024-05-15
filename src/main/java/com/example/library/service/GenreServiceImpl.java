package com.example.library.service;

import com.example.library.model.Genre;
import com.example.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(Integer id) {
        return genreRepository.findById(id);
    }

    @Override
    public Genre createGenre(Genre genre) {
        try {
            return genreRepository.save(genre);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create Genre", e);
        }
    }

    @Override
    public Genre updateGenre(Integer id, Genre genreDetails) {
        try {
            genreDetails.setGenreId(id);
            return genreRepository.save(genreDetails);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update Genre", e);
        }
    }

    @Override
    public void deleteGenre(Integer id) {
        try {
            genreRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete Genre", e);
        }
    }
}
