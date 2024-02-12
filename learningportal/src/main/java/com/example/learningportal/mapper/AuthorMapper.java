package com.example.learningportal.mapper;

import java.util.HashMap;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.learningportal.model.Course;
import com.example.learningportal.model.User;
import com.example.learningportal.model.dto.AuthorDto;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
	@Mapping(source = "courses", target = "courses")
	AuthorDto toDto(User a);

	default HashMap<Integer, String> toDtoList(List<Course> courses) {
		HashMap<Integer, String> mp = new HashMap<>();
		for (Course c : courses) {
			mp.put(c.getCourseId(), c.getCourseName());
		}
		return mp;
	}

	List<AuthorDto> getDtoList(List<User> authors);
}
