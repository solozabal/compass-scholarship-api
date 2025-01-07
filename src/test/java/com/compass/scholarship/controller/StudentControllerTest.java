package com.compass.scholarship.controller;

import com.compass.scholarship.model.Student;
import com.compass.scholarship.service.StudentService;
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
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        Student student = new Student("David", "david@example.com");
        student.setId(1L);
        when(studentService.findAll()).thenReturn(Collections.singletonList(student));

        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("David"));
    }

    @Test
    public void testGetStudentById() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        Student student = new Student("David", "david@example.com");
        student.setId(1L);
        when(studentService.findById(1L)).thenReturn(Optional.of(student));

        mockMvc.perform(get("/api/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("David"));
    }

    @Test
    public void testCreateStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        Student student = new Student("David", "david@example.com");
        when(studentService.save(any(Student.class))).thenReturn(student);

        mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"David\", \"email\": \"david@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("David"));
    }
}