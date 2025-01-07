package com.compass.scholarship.controller;

import com.compass.scholarship.model.Organizer;
import com.compass.scholarship.service.OrganizerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class OrganizerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrganizerService organizerService;

    @InjectMocks
    private OrganizerController organizerController;

    @Test
    public void testGetAllOrganizers() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(organizerController).build();
        Organizer organizer = new Organizer(1L, "Alice", "Coordinator");
        when(organizerService.findAll()).thenReturn(Collections.singletonList(organizer));

        mockMvc.perform(get("/api/organizers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    public void testGetOrganizerById() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(organizerController).build();
        Organizer organizer = new Organizer(1L, "Alice", "Coordinator");
        when(organizerService.findById(1L)).thenReturn(organizer);

        mockMvc.perform(get("/api/organizers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    public void testCreateOrganizer() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(organizerController).build();
        Organizer organizer = new Organizer(1L, "Alice", "Coordinator");
        when(organizerService.save(any(Organizer.class))).thenReturn(organizer);

        mockMvc.perform(post("/api/organizers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Alice\", \"role\": \"Coordinator\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }
}