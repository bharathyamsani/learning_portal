package com.example.learningportal.model.Dto;

import java.util.HashMap;

import lombok.Data;

@Data
public class AuthorDto {
	private int userId;
	private String username;
	private HashMap<Integer, String> courses;
}
