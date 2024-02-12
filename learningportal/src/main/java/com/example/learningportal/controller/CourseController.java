package com.example.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.model.dto.CourseDto;
import com.example.learningportal.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/learningportal")
@ResponseStatus(value = HttpStatus.OK)
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public List<CourseDto> getCourses() {
		log.info("Request for list of categories");
		List<CourseDto> courses = courseService.getCourses();
		log.info("Got categories list");
		return courses;
	}

	@GetMapping("courses/{id}")
	public CourseDto getCourse(int id) {
		log.info("Request course with id:" + id);
		CourseDto course = courseService.getCourse(id);
		log.info("Got course with id:" + id);
		return course;
	}

}
