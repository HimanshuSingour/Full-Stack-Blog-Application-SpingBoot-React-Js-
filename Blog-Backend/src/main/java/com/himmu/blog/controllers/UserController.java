package com.himmu.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himmu.blog.dto.ApiResponse;
import com.himmu.blog.dto.UserDTO;
import com.himmu.blog.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUserdd(@RequestBody UserDTO userdto){
		
		UserDTO createUserDTO = userService.createUser(userdto);
		return new ResponseEntity<>(createUserDTO , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userdto , @PathVariable("userId") Integer userId){
		
		UserDTO userdtos = userService.updateUser(userdto, userId);
		return new ResponseEntity<UserDTO>(userdtos , HttpStatus.OK);
		
	} 
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Integer userId){
		
		UserDTO userdto = userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(userdto , HttpStatus.OK);	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getAllusers(){
		
		List<UserDTO> userdto = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(userdto , HttpStatus.OK);
			
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
		 userService.deletUser(userId); 
		 
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully" , true), HttpStatus.OK);
		 
			
	}
}