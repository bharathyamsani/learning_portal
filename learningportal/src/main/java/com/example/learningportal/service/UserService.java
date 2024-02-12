package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.Category;
import com.example.learningportal.model.Course;
import com.example.learningportal.model.User;
import com.example.learningportal.model.dto.AuthorDto;
import com.example.learningportal.model.dto.CategoryDto;
import com.example.learningportal.model.dto.CourseDto;
import com.example.learningportal.model.dto.LearnerDto;
import com.example.learningportal.model.dto.UserDto;

public interface UserService {
	UserDto createUser(User u);

	List<UserDto> getUsers();

	void deleteUser(int id);

	AuthorDto addCourse(int id, Course c);

	LearnerDto addFavourite(int id, int cid);

	LearnerDto enrollCourse(int id, int cid);

	List<CourseDto> getCourses();

	AuthorDto updateCourse(int id, int cid, Course c);

	CategoryDto addCategory(Category c);
}
