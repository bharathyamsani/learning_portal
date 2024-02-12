package com.example.learningportal;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.learningportal.repository.UserRepository;

@SpringBootApplication
public class LearningPortalApplication {
	static UserRepository userRepository;

	public static void main(String[] args) throws BeansException {
		SpringApplication.run(LearningPortalApplication.class, args);

	}

}
