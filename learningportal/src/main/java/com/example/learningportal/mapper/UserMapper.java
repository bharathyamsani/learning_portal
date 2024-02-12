package com.example.learningportal.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.learningportal.model.User;
import com.example.learningportal.model.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(User u);

	User toEnt(UserDto u);

	List<UserDto> toDtoList(List<User> users);
}
