package com.compass.scholarship.service;

import com.compass.scholarship.exception.ResourceNotFoundException;
import com.compass.scholarship.model.Organizer;
import com.compass.scholarship.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public List<Organizer> findAll() {
        return organizerRepository.findAll();
    }

    public Organizer findById(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + id));
    }

    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer update(Long id, Organizer organizerDetails) {
        Organizer organizer = organizerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + id));
        organizer.setName(organizerDetails.getName());
        organizer.setRole(organizerDetails.getRole());
        return organizerRepository.save(organizer);
    }

    public void delete(Long id) {
        Organizer organizer = organizerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id " + id));
        organizerRepository.delete(organizer);
    }
}