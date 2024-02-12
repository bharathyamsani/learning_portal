package com.example.learningportal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.mapper.AuthorMapper;
import com.example.learningportal.model.User;
import com.example.learningportal.model.UserType;
import com.example.learningportal.model.Dto.AuthorDto;
import com.example.learningportal.repository.UserRepository;
import com.example.learningportal.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorMapper authorMapper;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<AuthorDto> getAuthors() {
		List<User> authors = new ArrayList<>();
		for (User u : userRepository.findAll()) {
			if (u.getUserType() == UserType.valueOf("AUTHOR")) {
				authors.add(u);
			}
		}
		return authorMapper.getDtoList(authors);
	}

}
