package com.example.learningportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learningportal.exception.ResourceNotFoundException;
import com.example.learningportal.mapper.CategoryMapper;
import com.example.learningportal.model.Category;
import com.example.learningportal.model.Dto.CategoryDto;
import com.example.learningportal.repository.CategoryRepository;
import com.example.learningportal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryMapper catMapper;

	@Override
	public List<CategoryDto> getCategories() {
		return catMapper.toDtoList(categoryRepository.findAll());
	}

	@Override
	public CategoryDto getCategory(int id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (!category.isPresent()) {
			throw new ResourceNotFoundException("Category", id);
		}
		return catMapper.toDto(category.get());
	}

}
