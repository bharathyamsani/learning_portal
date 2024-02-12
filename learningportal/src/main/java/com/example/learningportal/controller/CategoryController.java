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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/learningportal")
@ResponseStatus(value = HttpStatus.OK)
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("categories")
	public List<CategoryDto> getCategories() {
		log.info("Request for list of categories");
		List<CategoryDto> categories = categoryService.getCategories();
		log.info("Got categories list");
		return categories;
	}

	@GetMapping("categories/{id}")
	public CategoryDto getCategory(int id) {
		log.info("Request category with id:" + id);
		CategoryDto category = categoryService.getCategory(id);
		log.info("Got category with id:" + id);
		return category;
	}

}
