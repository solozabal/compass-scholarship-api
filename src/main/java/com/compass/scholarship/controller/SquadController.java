package com.compass.scholarship.controller;

import com.compass.scholarship.model.Squad;
import com.compass.scholarship.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/squads")
public class SquadController {

    @Autowired
    private SquadService squadService;

    @GetMapping
    public List<Squad> getAllSquads() {
        return squadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Squad> getSquadById(@PathVariable Long id) {
        Squad squad = squadService.findById(id);
        return ResponseEntity.ok(squad);
    }

    @PostMapping
    public Squad createSquad(@RequestBody Squad squad) {
        return squadService.save(squad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Squad> updateSquad(@PathVariable Long id, @RequestBody Squad squadDetails) {
        Squad updatedSquad = squadService.update(id, squadDetails);
        return ResponseEntity.ok(updatedSquad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSquad(@PathVariable Long id) {
        squadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}