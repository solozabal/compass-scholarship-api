package com.compass.scholarship.service;

import com.compass.scholarship.model.Lesson;
import com.compass.scholarship.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Optional<Lesson> updateLesson(Long id, Lesson lessonDetails) {
        return lessonRepository.findById(id).map(lesson -> {
            lesson.setTitle(lessonDetails.getTitle());
            lesson.setDate(lessonDetails.getDate());
            return lessonRepository.save(lesson);
        });
    }

    public boolean deleteLesson(Long id) {
        return lessonRepository.findById(id).map(lesson -> {
            lessonRepository.delete(lesson);
            return true;
        }).orElse(false);
    }
}