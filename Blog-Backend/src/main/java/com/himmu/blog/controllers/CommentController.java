package com.himmu.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himmu.blog.dto.ApiResponse;
import com.himmu.blog.dto.CommentDTO;
import com.himmu.blog.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentservice;
	
	@PostMapping("/create/{postId}")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentdto , @PathVariable Integer postId){
		
		CommentDTO commentdtos = commentservice.createCommect(commentdto, postId);
		return new ResponseEntity<CommentDTO>(commentdtos , HttpStatus.CREATED);
	}
	
	// here Update API is Implement
	
	@DeleteMapping("/delet/{commentId}")
	public ResponseEntity<ApiResponse> deletComment(@PathVariable Integer commentId){
		
		commentservice.deletComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully" , true),
				HttpStatus.OK);
		
	}
	
}
