package com.mybackend.blog.services;

import java.util.List;

import com.mybackend.blog.payloads.UserDto;

public interface UserService {
	
	
	//createUser
	UserDto createUser (UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();	
	void deleteUser(Integer userId);
	
}
