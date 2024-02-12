package com.example.learningportal.service;

import java.util.List;

import com.example.learningportal.model.Dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> getCategories();

	CategoryDto getCategory(int id);

}
