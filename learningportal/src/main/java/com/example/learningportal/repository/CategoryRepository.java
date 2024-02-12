package com.example.learningportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningportal.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
