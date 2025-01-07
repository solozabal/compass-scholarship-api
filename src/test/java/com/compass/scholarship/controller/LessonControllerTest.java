package com.compass.scholarship.controller;

import com.compass.scholarship.model.Lesson;
import com.compass.scholarship.service.LessonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class LessonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LessonService lessonService;

    @InjectMocks
    private LessonController lessonController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
    }

    @Test
    public void testGetAllLessons() throws Exception {
        Lesson lesson = new Lesson(1L, "Lesson 1", "Description");
        lesson.setDate(LocalDateTime.now());
        when(lessonService.getAllLessons()).thenReturn(Collections.singletonList(lesson));

        mockMvc.perform(get("/api/lessons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Lesson 1"));
    }

    @Test
    public void testGetLessonById() throws Exception {
        Lesson lesson = new Lesson(1L, "Lesson 1", "Description");
        lesson.setDate(LocalDateTime.now());
        when(lessonService.getLessonById(1L)).thenReturn(Optional.of(lesson));

        mockMvc.perform(get("/api/lessons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Lesson 1"));
    }

    @Test
    public void testCreateLesson() throws Exception {
        // Definindo uma data fixa para evitar problemas de comparação
        LocalDateTime fixedDate = LocalDateTime.of(2025, 1, 7, 10, 0);
        
        // Criação do objeto Lesson com todos os dados necessários
        Lesson lesson = new Lesson(1L, "Lesson 1", "Description");
        lesson.setDate(fixedDate);
        
        // Configurando o mock para retornar esse objeto quando createLesson for chamado
        when(lessonService.createLesson(any(Lesson.class))).thenReturn(lesson);

        // Realizando a requisição POST para criar a lição
        mockMvc.perform(post("/api/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Lesson 1\", \"description\": \"Description\", \"date\": \"" + fixedDate.toString() + "\"}"))
                .andExpect(status().isCreated()) // Alterado para 201 Created
                .andExpect(jsonPath("$.title").value("Lesson 1"));
    }
}
