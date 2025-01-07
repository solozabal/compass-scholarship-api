package com.compass.scholarship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compass.scholarship.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}