package com.example.learningportal.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.learningportal.model.Course;
import com.example.learningportal.model.dto.CourseDto;

@Mapper(componentModel = "spring")
public interface CourseMapper {
	@Mapping(source = "category.categoryName", target = "categoryName")
	@Mapping(source = "author.username", target = "author")
	CourseDto toDto(Course c);

	List<CourseDto> toDtoList(List<Course> c);

}
