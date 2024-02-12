package com.example.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.authentication.AuthenticationService;
import com.example.learningportal.exception.NotAuthorizedException;
import com.example.learningportal.model.Category;
import com.example.learningportal.model.Course;
import com.example.learningportal.model.User;
import com.example.learningportal.model.UserType;
import com.example.learningportal.model.dto.AuthorDto;
import com.example.learningportal.model.dto.CategoryDto;
import com.example.learningportal.model.dto.CourseDto;
import com.example.learningportal.model.dto.LearnerDto;
import com.example.learningportal.model.dto.UserDto;
import com.example.learningportal.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/learningportal")
@ResponseStatus(value = HttpStatus.OK)
@Slf4j
public class UserController {
	@Autowired
	private AuthenticationService authService;
	@Autowired
	private UserService userService;

	@GetMapping("users")
	public List<UserDto> getUsers() {
		log.info("Requested to get users");
		return userService.getUsers();

	}

	@PostMapping("{id}/addUser")
	public UserDto createUser(@PathVariable(name = "id") int id, @RequestBody User u) throws NotAuthorizedException {
		log.info("Requested to add user");
		if (authService.authenticate(id, UserType.ADMIN)) {
			log.info("User Added");
			return userService.createUser(u);
		} else {
			throw new NotAuthorizedException("Not authorized");
		}
	}

	@PostMapping("{id}/addCategory")
	public CategoryDto addCategory(@PathVariable(name = "id") int id, @RequestBody Category c)
			throws NotAuthorizedException {
		log.info("Requested to add category");
		if (authService.authenticate(id, UserType.ADMIN)) {
			CategoryDto category = userService.addCategory(c);
			log.info("Category Added");
			return category;
		} else {
			throw new NotAuthorizedException("Not authorized");
		}
	}

	@GetMapping("{id}/users")
	public List<UserDto> getUsers(@PathVariable int id) throws NotAuthorizedException {
		log.info("Requested to add users");
		if (authService.authenticate(id, UserType.ADMIN)) {
			List<UserDto> users = userService.getUsers();
			log.info("Got list of users");
			return users;
		} else {
			throw new NotAuthorizedException("Not authorized");
		}
	}

	@DeleteMapping("{id1}/delete/{id2}")
	public String deleteUser(@PathVariable(name = "id1") int id1, @PathVariable(name = "id2") int id2)
			throws NotAuthorizedException {
		log.info("Requested to deleted user");
		if (authService.authenticate(id1, UserType.ADMIN)) {
			userService.deleteUser(id2);
			log.info("User deleted");
			return "Deleted user with id:" + id2;
		} else {
			throw new NotAuthorizedException("Not authorized");
		}
	}

	@PostMapping("{id}/addCourse")
	public AuthorDto addCourse(@PathVariable(name = "id") int id, @RequestBody Course c) throws NotAuthorizedException {
		log.info("Requested to add course");
		if (authService.authenticate(id, UserType.AUTHOR)) {
			AuthorDto author = userService.addCourse(id, c);
			log.info("User added");
			return author;
		} else {
			throw new NotAuthorizedException("Not authorized");
		}
	}

	@PutMapping("{id}/updateCourse/{cid}")
	public AuthorDto updateCourse(@PathVariable(name = "id") int id, @PathVariable(name = "cid") int cid,
			@RequestBody Course c) {
		log.info("Requested to update course");
		if (authService.authenticate(id, UserType.AUTHOR)) {
			AuthorDto authorDto = userService.updateCourse(id, cid, c);
			log.info("Course Updated");
			return authorDto;
		} else {
			throw new NotAuthorizedException("Not Authorized");
		}

	}

	@PostMapping("{id1}/addFavourite/{id2}")
	public LearnerDto addFavourite(@PathVariable(name = "id1") int id1, @PathVariable(name = "id2") int cid) {
		log.info("Requested to add favourite");
		if (authService.authenticate(id1, UserType.LEARNER)) {
			LearnerDto learner = userService.addFavourite(id1, cid);
			log.info("favourited added");
			return learner;
		} else {
			throw new NotAuthorizedException("Not Authorized");
		}
	}

	@PostMapping("{id}/enrollCourse/{id2}")
	public LearnerDto enrollCourse(@PathVariable(name = "id") int id, @PathVariable(name = "id2") int cid)
			throws NotAuthorizedException {
		log.info("Requested to enroll course");
		if (authService.authenticate(id, UserType.LEARNER)) {
			LearnerDto learner = userService.enrollCourse(id, cid);
			log.info("Enrolled course");
			return learner;
		} else {
			throw new NotAuthorizedException("Not authorized");
		}
	}

	@GetMapping("{id}/courses")
	public List<CourseDto> getCourses(@PathVariable(name = "id") int id) {
		log.info("Requested to get courses");
		if (authService.authenticate(id, UserType.LEARNER)) {
			List<CourseDto> courses = userService.getCourses();
			log.info("Got list of courses");
			return courses;
		} else {
			throw new NotAuthorizedException("Not Authorized");
		}
	}
}
