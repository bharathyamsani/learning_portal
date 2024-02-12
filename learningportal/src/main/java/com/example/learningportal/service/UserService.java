package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.Category;
import com.example.learningportal.model.Course;
import com.example.learningportal.model.User;
import com.example.learningportal.model.Dto.AuthorDto;
import com.example.learningportal.model.Dto.CategoryDto;
import com.example.learningportal.model.Dto.CourseDto;
import com.example.learningportal.model.Dto.LearnerDto;
import com.example.learningportal.model.Dto.UserDto;

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
