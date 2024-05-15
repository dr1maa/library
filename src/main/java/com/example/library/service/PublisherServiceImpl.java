package com.example.library.service;

import com.example.library.model.Publisher;
import com.example.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherById(Integer id) {
        return publisherRepository.findById(id);
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        try {
            return publisherRepository.save(publisher);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create Publisher", e);
        }
    }

    @Override
    public Publisher updatePublisher(Integer id, Publisher publisherDetails) {
        try {
            publisherDetails.setPublisherId(id);
            return publisherRepository.save(publisherDetails);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update Publisher", e);
        }
    }

    @Override
    public void deletePublisher(Integer id) {
        try {
            publisherRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete Publisher", e);
        }
    }
}
