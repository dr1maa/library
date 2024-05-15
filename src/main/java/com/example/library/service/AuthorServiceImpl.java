package com.example.library.service;


import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        try {

            return authorRepository.save(author);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create Author" + e.getMessage());
        }
    }

    @Override
    public Author updateAuthor(Integer id, Author authorDetails) {
        try {
            authorDetails.setAuthorId(id);
            return authorRepository.save(authorDetails);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update Author" + e.getMessage());
        }
    }

    @Override
    public void deleteAuthor(Integer id) {
        try {
            authorRepository.deleteById(id);
        } catch (
                DataAccessException e
        ) {
            throw new RuntimeException("Failed to delete Author " + e.getMessage());
        }
    }
}