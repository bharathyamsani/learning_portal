package com.example.learningportal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.exception.ResourceNotFoundException;
import com.example.learningportal.mapper.LearnerMapper;
import com.example.learningportal.model.User;
import com.example.learningportal.model.UserType;
import com.example.learningportal.model.Dto.LearnerDto;
import com.example.learningportal.repository.UserRepository;
import com.example.learningportal.service.LearnerService;

@Service
public class LearnerServiceImpl implements LearnerService {

	@Autowired
	private LearnerMapper learnerMapper;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<LearnerDto> getLearners() {
		List<User> learners = new ArrayList<>();
		for (User u : userRepository.findAll()) {
			if (u.getUserType() == UserType.valueOf("LEARNER")) {
				learners.add(u);
			}
		}
		return learnerMapper.getDtoList(learners);
	}

	@Override
	public LearnerDto getLearner(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			if (user.get().getUserType() != UserType.valueOf("LEARNER")) {
				return learnerMapper.toDto(user.get());
			} else {
				throw new ResourceNotFoundException("Learner", id);
			}
		} else {
			throw new ResourceNotFoundException("User", id);
		}
	}

}
