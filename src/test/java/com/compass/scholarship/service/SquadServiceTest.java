package com.compass.scholarship.service;

import com.compass.scholarship.model.Squad;
import com.compass.scholarship.repository.SquadRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SquadServiceTest {

    @Mock
    private SquadRepository squadRepository;

    @InjectMocks
    private SquadService squadService;

    @Test
    public void testFindById() {
        Squad squad = new Squad();
        squad.setId(1L);
        squad.setName("Squad A");
        when(squadRepository.findById(1L)).thenReturn(Optional.of(squad));

        Squad foundSquad = squadService.findById(1L);
        assertNotNull(foundSquad);
        assertEquals("Squad A", foundSquad.getName());
    }

    @Test
    public void testSaveSquad() {
        Squad squad = new Squad();
        squad.setId(1L);
        squad.setName("Squad A");
        when(squadRepository.save(squad)).thenReturn(squad);

        Squad savedSquad = squadService.save(squad);
        assertNotNull(savedSquad);
        assertEquals("Squad A", savedSquad.getName());
    }

    @Test
    public void testDeleteSquad() {
        Squad squad = new Squad();
        squad.setId(1L);
        squad.setName("Squad A");
        when(squadRepository.findById(1L)).thenReturn(Optional.of(squad));
        doNothing().when(squadRepository).delete(squad);

        squadService.delete(1L);
        verify(squadRepository, times(1)).delete(squad);
    }
}