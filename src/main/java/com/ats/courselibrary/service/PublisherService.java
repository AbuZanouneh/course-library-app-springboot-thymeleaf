package com.ats.courselibrary.service;

import com.ats.courselibrary.entity.Publisher;
import com.ats.courselibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service layer
@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long publisherId){
        Publisher publisher;
        publisher  = publisherRepository.findById(publisherId).orElseThrow(() -> new RuntimeException("Publisher  not found"));
        return publisher;
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long publisherId){
        Publisher publisher;
        publisher  = publisherRepository.findById(publisherId).orElseThrow(() -> new RuntimeException("Publisher  not found"));
        publisherRepository.deleteById(publisher.getPublisherId());
    }

}
