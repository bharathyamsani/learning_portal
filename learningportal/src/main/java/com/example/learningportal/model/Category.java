package com.example.learningportal.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int categoryId;
	@Column(name="categoryName")
	private String categoryName;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("category")
	private List<Course> courses;
	@CreationTimestamp
	private LocalDateTime created_on;
	@UpdateTimestamp
	private LocalDateTime updated_on;

}
