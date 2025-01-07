package com.compass.scholarship.service;

import com.compass.scholarship.model.Organizer;
import com.compass.scholarship.repository.OrganizerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrganizerServiceTest {

    @Mock
    private OrganizerRepository organizerRepository;

    @InjectMocks
    private OrganizerService organizerService;

    @Test
    public void testFindById() {
        Organizer organizer = new Organizer(1L, "Alice", "Coordinator");
        when(organizerRepository.findById(1L)).thenReturn(Optional.of(organizer));

        Organizer foundOrganizer = organizerService.findById(1L);
        assertNotNull(foundOrganizer);
        assertEquals("Alice", foundOrganizer.getName());
    }

    @Test
    public void testSaveOrganizer() {
        Organizer organizer = new Organizer(1L, "Alice", "Coordinator");
        when(organizerRepository.save(organizer)).thenReturn(organizer);

        Organizer savedOrganizer = organizerService.save(organizer);
        assertNotNull(savedOrganizer);
        assertEquals("Alice", savedOrganizer.getName());
    }

    @Test
    public void testDeleteOrganizer() {
        Organizer organizer = new Organizer(1L, "Alice", "Coordinator");
        when(organizerRepository.findById(1L)).thenReturn(Optional.of(organizer));
        doNothing().when(organizerRepository).delete(organizer);

        organizerService.delete(1L);
        verify(organizerRepository, times(1)).delete(organizer);
    }
}