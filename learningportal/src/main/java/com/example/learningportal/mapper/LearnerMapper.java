package com.example.learningportal.mapper;

import java.util.HashMap;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.learningportal.model.Course;
import com.example.learningportal.model.User;
import com.example.learningportal.model.Dto.LearnerDto;

@Mapper(componentModel = "spring")
public interface LearnerMapper {
	@Mapping(source = "enrolledCourses", target = "courses")
	LearnerDto toDto(User u);

	default HashMap<Integer, String> toDtoList(List<Course> courses) {
		HashMap<Integer, String> mp = new HashMap<>();
		for (Course c : courses) {
			mp.put(c.getCourseId(), c.getCourseName());
		}
		return mp;
	}

	List<LearnerDto> getDtoList(List<User> learners);
}
