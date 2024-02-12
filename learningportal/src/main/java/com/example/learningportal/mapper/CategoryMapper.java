package com.example.learningportal.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.learningportal.model.Category;
import com.example.learningportal.model.Dto.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	CategoryDto toDto(Category c);

	Category toEnt(CategoryDto c);

	List<CategoryDto> toDtoList(List<Category> l);
}
