package com.compass.scholarship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.compass.scholarship.model.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}