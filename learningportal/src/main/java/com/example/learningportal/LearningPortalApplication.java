package com.example.learningportal;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.learningportal.repository.UserRepository;

@SpringBootApplication
public class LearningPortalApplication {
	static UserRepository userRepository;

	public static void main(String[] args) throws BeansException {
		ConfigurableApplicationContext con = SpringApplication.run(LearningPortalApplication.class, args);
		//		userRepository = con.getBean(UserRepository.class);
		//		User u = new User();
		//		u.setUsername("Shiva");
		//		u.setUserType(UserType.ADMIN);
		//		userRepository.save(u);

	}

}
