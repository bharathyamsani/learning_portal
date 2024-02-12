package com.example.learningportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.exception.NotAuthorizedException;
import com.example.learningportal.exception.ResourceNotFoundException;
import com.example.learningportal.mapper.AuthorMapper;
import com.example.learningportal.mapper.CategoryMapper;
import com.example.learningportal.mapper.CourseMapper;
import com.example.learningportal.mapper.LearnerMapper;
import com.example.learningportal.mapper.UserMapper;
import com.example.learningportal.model.Category;
import com.example.learningportal.model.Course;
import com.example.learningportal.model.User;
import com.example.learningportal.model.UserType;
import com.example.learningportal.model.Dto.AuthorDto;
import com.example.learningportal.model.Dto.CategoryDto;
import com.example.learningportal.model.Dto.CourseDto;
import com.example.learningportal.model.Dto.LearnerDto;
import com.example.learningportal.model.Dto.UserDto;
import com.example.learningportal.repository.CategoryRepository;
import com.example.learningportal.repository.CourseRepository;
import com.example.learningportal.repository.UserRepository;
import com.example.learningportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AuthorMapper authorMapper;
	@Autowired
	private LearnerMapper learnerMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public UserDto createUser(User u) {
		return userMapper.toDto(userRepository.save(u));
	}

	@Override
	public List<UserDto> getUsers() {
		return userMapper.toDtoList(userRepository.findAll());
	}

	@Override
	public void deleteUser(int id) {
		Optional<User> user2 = userRepository.findById(id);
		if (user2.isPresent()) {
			if (user2.get().getUserType() != UserType.ADMIN) {

				userRepository.delete(user2.get());

			} else {
				throw new NotAuthorizedException("Not authorized");
			}
		} else {
			throw new ResourceNotFoundException("User", id);
		}
	}

	@Override
	public AuthorDto addCourse(int id, Course c) {
		Optional<User> user = userRepository.findById(id);
		int cid = c.getCategory().getCategoryId();
		Optional<Category> category = categoryRepository.findById(cid);
		if (category.isPresent()) {
			c.setAuthor(user.get());
			c.setCategory(category.get());
			user.get().getCourses().add(c);
			userRepository.save(user.get());
		} else {
			throw new ResourceNotFoundException("Category", cid);
		}
		return authorMapper.toDto(user.get());
	}

	@Override
	public LearnerDto addFavourite(int id, int cid) {
		Optional<User> user = userRepository.findById(id);
		Optional<Course> course = courseRepository.findById(cid);
		if (course.isPresent()) {
			user.get().getFavCourses().add(course.get());
		} else {
			throw new ResourceNotFoundException("Course", cid);
		}
		userRepository.save(user.get());
		return learnerMapper.toDto(user.get());
	}

	@Override
	public LearnerDto enrollCourse(int id, int cid) {
		Optional<User> user = userRepository.findById(id);
		Optional<Course> course = courseRepository.findById(cid);
		if (course.isPresent()) {
			user.get().getEnrolledCourses().add(course.get());
		} else {
			throw new ResourceNotFoundException("Course", cid);
		}
		userRepository.save(user.get());
		return learnerMapper.toDto(user.get());
	}

	@Override
	public List<CourseDto> getCourses() {
		return courseMapper.toDtoList(courseRepository.findAll());
	}

	@Override
	public AuthorDto updateCourse(int id, int cid, Course c) {
		Optional<User> user = userRepository.findById(id);
		for (Course course : user.get().getCourses()) {
			if (course.getCourseId() == cid) {
				course.setCourseName(c.getCourseName());
				if (categoryRepository.findById(c.getCategory().getCategoryId()).isPresent()) {
					course.setCategory(categoryRepository.findById(c.getCategory().getCategoryId()).get());
				}
			}
		}
		return authorMapper.toDto(userRepository.save(user.get()));
	}

	@Override
	public CategoryDto addCategory(Category c) {
		return categoryMapper.toDto(categoryRepository.save(c));
	}

}
