package com.example.learningportal.authentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.exception.ResourceNotFoundException;
import com.example.learningportal.model.User;
import com.example.learningportal.model.UserType;
import com.example.learningportal.repository.UserRepository;

@Service
public class AuthenticationService {
	@Autowired
	private UserRepository userRepository;

	public boolean authenticate(int id, UserType type) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new ResourceNotFoundException("User", id);
		}
		return user.get().getUserType() == type;
	}
}
