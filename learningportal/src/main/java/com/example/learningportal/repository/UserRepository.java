package com.example.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learningportal.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
