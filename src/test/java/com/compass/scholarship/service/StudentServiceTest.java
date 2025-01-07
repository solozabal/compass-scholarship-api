package com.compass.scholarship.service;

import com.compass.scholarship.model.Student;
import com.compass.scholarship.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testFindById() {
        Student student = new Student("David", "david@example.com");
        student.setId(1L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.findById(1L).orElse(null);
        assertNotNull(foundStudent);
        assertEquals("David", foundStudent.getName());
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student("David", "david@example.com");
        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.save(student);
        assertNotNull(savedStudent);
        assertEquals("David", savedStudent.getName());
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("David", "david@example.com");
        student.setId(1L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        doNothing().when(studentRepository).delete(student);

        studentService.delete(1L);
        verify(studentRepository, times(1)).delete(student);
    }
}