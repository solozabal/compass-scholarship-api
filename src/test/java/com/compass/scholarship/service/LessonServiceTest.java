package com.compass.scholarship.service;

import com.compass.scholarship.model.Lesson;
import com.compass.scholarship.repository.LessonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LessonServiceTest {

    @Mock
    private LessonRepository lessonRepository;

    @InjectMocks
    private LessonService lessonService;

    @Test
    public void testGetLessonById() {
        Lesson lesson = new Lesson(1L, "Lesson 1", "Description");
        lesson.setDate(LocalDateTime.now());
        when(lessonRepository.findById(1L)).thenReturn(Optional.of(lesson));

        Optional<Lesson> foundLesson = lessonService.getLessonById(1L);
        assertTrue(foundLesson.isPresent());
        assertEquals("Lesson 1", foundLesson.get().getTitle());
    }

    @Test
    public void testCreateLesson() {
        Lesson lesson = new Lesson(1L, "Lesson 1", "Description");
        lesson.setDate(LocalDateTime.now());
        when(lessonRepository.save(any(Lesson.class))).thenReturn(lesson);

        Lesson createdLesson = lessonService.createLesson(lesson);
        assertNotNull(createdLesson);
        assertEquals("Lesson 1", createdLesson.getTitle());
    }

    @Test
    public void testDeleteLesson() {
        Lesson lesson = new Lesson(1L, "Lesson 1", "Description");
        lesson.setDate(LocalDateTime.now());
        when(lessonRepository.findById(1L)).thenReturn(Optional.of(lesson));
        
        // Use 'when' to ensure the delete method is called correctly.
        doNothing().when(lessonRepository).delete(any(Lesson.class));

        boolean isDeleted = lessonService.deleteLesson(1L);
        assertTrue(isDeleted);
        verify(lessonRepository, times(1)).delete(any(Lesson.class));
    }
}
