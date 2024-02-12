package com.example.learningportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningportal.model.Dto.CategoryDto;
import com.example.learningportal.service.CategoryService;

@RestController
@RequestMapping("/api/learningportal")
@ResponseStatus(value = HttpStatus.OK)
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("categories")
	public List<CategoryDto> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("categories/{id}")
	public CategoryDto getCategory(int id) {
		return categoryService.getCategory(id);
	}

}
