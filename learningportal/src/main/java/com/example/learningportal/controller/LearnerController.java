package com.example.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.model.Dto.LearnerDto;
import com.example.learningportal.service.LearnerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/learningportal")
public class LearnerController {
	@Autowired
	private LearnerService learnerService;

	@GetMapping("learners")
	public List<LearnerDto> getAuthors() {
		log.info("Request to get authors");
		List<LearnerDto> learners = learnerService.getLearners();
		log.info("Got a list of authors");
		return learners;
	}

	@GetMapping("learners/{id}")
	public LearnerDto getAuthor(@PathVariable(name = "id") int id) {
		log.info("Request to get learner with id" + id);
		LearnerDto learner = learnerService.getLearner(id);
		log.info("Got learner with id:" + id);
		return learner;
	}

}
