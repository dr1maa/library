package com.example.library.service;

import com.example.library.repositoryImpl.PublisherRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepositoryImpl publisherRepository;

}