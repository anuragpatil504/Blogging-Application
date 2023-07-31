package com.mybackend.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybackend.blog.exceptions.*;
import com.mybackend.blog.entities.User;
import com.mybackend.blog.payloads.UserDto;
import com.mybackend.blog.repositories.UserRepo;
import com.mybackend.blog.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		 User savedUser = this.userRepo.save(user);
		 return this.userToDto(savedUser); 	
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user =  this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User saveUser = this.userRepo.save(user);
		UserDto savedUserDto = this.userToDto(saveUser);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " Id ",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos ;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user =userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", " Id ",userId));
		this.userRepo.delete(user);
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		return userDto;
	}

}
