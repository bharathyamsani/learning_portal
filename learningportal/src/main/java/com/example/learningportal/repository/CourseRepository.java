package com.example.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningportal.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}