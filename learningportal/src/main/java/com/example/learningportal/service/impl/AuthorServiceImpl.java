package com.example.learningportal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.exception.ResourceNotFoundException;
import com.example.learningportal.mapper.AuthorMapper;
import com.example.learningportal.model.User;
import com.example.learningportal.model.UserType;
import com.example.learningportal.model.dto.AuthorDto;
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

	@Override
	public AuthorDto getAuthor(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			if (user.get().getUserType() != UserType.valueOf("AUTHOR")) {
				return authorMapper.toDto(user.get());
			} else {
				throw new ResourceNotFoundException("Author", id);
			}
		} else {
			throw new ResourceNotFoundException("User", id);
		}
	}

}
