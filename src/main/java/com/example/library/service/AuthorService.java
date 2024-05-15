package com.example.library.service;

import com.example.library.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Integer id);

    Author createAuthor(Author author);

    Author updateAuthor(Integer id, Author authorDetails);

    void deleteAuthor(Integer id);
}
