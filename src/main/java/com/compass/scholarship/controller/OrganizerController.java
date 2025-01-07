package com.compass.scholarship.controller;

import com.compass.scholarship.model.Organizer;
import com.compass.scholarship.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        Organizer organizer = organizerService.findById(id);
        return ResponseEntity.ok(organizer);
    }

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.save(organizer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizerDetails) {
        Organizer updatedOrganizer = organizerService.update(id, organizerDetails);
        return ResponseEntity.ok(updatedOrganizer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}