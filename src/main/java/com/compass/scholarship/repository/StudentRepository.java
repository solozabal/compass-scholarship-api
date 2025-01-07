package com.compass.scholarship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compass.scholarship.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}