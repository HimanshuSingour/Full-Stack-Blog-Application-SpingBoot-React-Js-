package com.himmu.blog.service;

import com.himmu.blog.dto.CommentDTO;

public interface CommentService {
	
	//create
	CommentDTO createCommect(CommentDTO commentdto , Integer postId);
   
	//deleted Comment
	void deletComment(Integer commentId);

	
}
