package com.example.learningportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.exception.ResourceNotFoundException;
import com.example.learningportal.mapper.CourseMapper;
import com.example.learningportal.model.Course;
import com.example.learningportal.model.dto.CourseDto;
import com.example.learningportal.repository.CourseRepository;
import com.example.learningportal.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<CourseDto> getCourses() {
		List<Course> courses = courseRepository.findAll();
		//		for (Course c : courses) {
		//			System.out.println(c);
		//		}
		return courseMapper.toDtoList(courseRepository.findAll());
	}

	@Override
	public CourseDto getCourse(int id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return courseMapper.toDto(course.get());
		} else {
			throw new ResourceNotFoundException("Course", id);
		}
	}

}
