package com.example.learningportal.model.dto;

import java.util.HashMap;

import lombok.Data;

@Data
public class LearnerDto {
	private int userId;
	private String username;
	private HashMap<Integer, String> courses;
	private HashMap<Integer, String> favCourses;
}
