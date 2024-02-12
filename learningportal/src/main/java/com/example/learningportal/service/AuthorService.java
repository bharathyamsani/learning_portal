package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.Dto.AuthorDto;

public interface AuthorService {
	List<AuthorDto> getAuthors();
}
