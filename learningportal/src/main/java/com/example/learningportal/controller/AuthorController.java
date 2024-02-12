package com.example.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.model.Dto.AuthorDto;
import com.example.learningportal.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/learningportal")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping("authors")
	public List<AuthorDto> getAuthor() {
		log.info("Request to get authors");
		List<AuthorDto> authors = authorService.getAuthors();
		log.info("Got a list of authors");
		return authors;
	}

	@GetMapping("learners/{id}")
	public AuthorDto getAuthor(@PathVariable(name = "id") int id) {
		log.info("Request to get author with id" + id);
		AuthorDto author = authorService.getAuthor(id);
		log.info("Got author with id:" + id);
		return author;
	}
}
