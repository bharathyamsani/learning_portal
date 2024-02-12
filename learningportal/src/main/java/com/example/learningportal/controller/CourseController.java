package com.example.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.model.Dto.CourseDto;
import com.example.learningportal.service.CourseService;

@RestController
@RequestMapping("api/learningportal")
@ResponseStatus(value = HttpStatus.OK)
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public List<CourseDto> getCourses() {
		return courseService.getCourses();
	}

	@GetMapping("courses/{id}")
	public CourseDto getCourse(int id) {
		return courseService.getCourse(id);
	}

}
