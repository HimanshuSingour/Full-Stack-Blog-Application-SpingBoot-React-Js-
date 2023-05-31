package com.himmu.blog.service;

import java.util.List;

import com.himmu.blog.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO user);
	
	UserDTO updateUser(UserDTO user , Integer userId);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUsers();
	
	void deletUser(Integer userId);

}
