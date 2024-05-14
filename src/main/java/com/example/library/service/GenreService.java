package com.example.library.service;

import com.example.library.model.Genre;
import com.example.library.repositoryImpl.GenreRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenreRepositoryImpl genreRepository;

    public GenreService(GenreRepositoryImpl genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteById(int id) {
        genreRepository.deleteById(id);
    }

}