package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.dto.CourseDto;

public interface CourseService {

	List<CourseDto> getCourses();

	CourseDto getCourse(int id);

}
