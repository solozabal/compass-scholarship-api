package com.compass.scholarship.controller;

import com.compass.scholarship.model.Squad;
import com.compass.scholarship.service.SquadService;
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
public class SquadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SquadService squadService;

    @InjectMocks
    private SquadController squadController;

    @Test
    public void testGetAllSquads() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(squadController).build();
        Squad squad = new Squad();
        squad.setId(1L);
        squad.setName("Squad A");
        when(squadService.findAll()).thenReturn(Collections.singletonList(squad));

        mockMvc.perform(get("/api/squads"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Squad A"));
    }

    @Test
    public void testGetSquadById() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(squadController).build();
        Squad squad = new Squad();
        squad.setId(1L);
        squad.setName("Squad A");
        when(squadService.findById(1L)).thenReturn(squad);

        mockMvc.perform(get("/api/squads/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Squad A"));
    }

    @Test
    public void testCreateSquad() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(squadController).build();
        Squad squad = new Squad();
        squad.setId(1L);
        squad.setName("Squad A");
        when(squadService.save(any(Squad.class))).thenReturn(squad);

        mockMvc.perform(post("/api/squads")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Squad A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Squad A"));
    }
}