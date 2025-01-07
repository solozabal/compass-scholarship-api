package com.compass.scholarship.service;

import com.compass.scholarship.exception.ResourceNotFoundException;
import com.compass.scholarship.model.Squad;
import com.compass.scholarship.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquadService {

    @Autowired
    private SquadRepository squadRepository;

    public List<Squad> findAll() {
        return squadRepository.findAll();
    }

    public Squad findById(Long id) {
        return squadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Squad not found with id " + id));
    }

    public Squad save(Squad squad) {
        return squadRepository.save(squad);
    }

    public Squad update(Long id, Squad squadDetails) {
        Squad squad = squadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Squad not found with id " + id));
        squad.setName(squadDetails.getName());
        squad.setMembers(squadDetails.getMembers());
        return squadRepository.save(squad);
    }

    public void delete(Long id) {
        Squad squad = squadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Squad not found with id " + id));
        squadRepository.delete(squad);
    }
}