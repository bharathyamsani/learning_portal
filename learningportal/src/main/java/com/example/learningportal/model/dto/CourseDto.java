package com.example.learningportal.model.dto;

import lombok.Data;

@Data
public class CourseDto {
	private int courseId;
	private String courseName;
	private String categoryName;
	private String author;
}
