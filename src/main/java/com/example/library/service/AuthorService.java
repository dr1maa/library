package com.example.library.service;


import com.example.library.model.Author;
import com.example.library.repositoryImpl.AuthorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepositoryImpl authorRepository;

    public AuthorService(AuthorRepositoryImpl authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findById(int id) {
        return authorRepository.findById(id);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {
        authorRepository.update(author);
    }

    public void delete(int id) {
        authorRepository.delete(id);
    }

}