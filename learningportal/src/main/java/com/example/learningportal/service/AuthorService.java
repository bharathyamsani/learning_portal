package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.dto.AuthorDto;

public interface AuthorService {
	List<AuthorDto> getAuthors();

	AuthorDto getAuthor(int id);
}
