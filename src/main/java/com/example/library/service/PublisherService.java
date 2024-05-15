package com.example.library.service;

import com.example.library.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> getAllPublishers();

    Optional<Publisher> getPublisherById(Integer id);

    Publisher createPublisher(Publisher publisher);

    Publisher updatePublisher(Integer id, Publisher publisherDetails);

    void deletePublisher(Integer id);
}
