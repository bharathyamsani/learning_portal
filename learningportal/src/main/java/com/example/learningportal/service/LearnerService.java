package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.Dto.LearnerDto;

public interface LearnerService {

	List<LearnerDto> getLearners();

	LearnerDto getLearner(int id);

}
