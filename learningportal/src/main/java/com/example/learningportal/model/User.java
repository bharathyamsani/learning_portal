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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Column(name = "userName")
	private String username;
	@Column(name = "userType")
	private UserType userType;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("users")
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private List<Course> courses;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JsonIgnoreProperties({ "users" })
	@JoinTable(name = "enrolledCourses", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private List<Course> enrolledCourses;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JsonIgnoreProperties({ "users" })
	@JoinTable(name = "favCourses", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private List<Course> favCourses;
	@CreationTimestamp
	private LocalDateTime created_on;
	@UpdateTimestamp
	private LocalDateTime updated_on;

}
