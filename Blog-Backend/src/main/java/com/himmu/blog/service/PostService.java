package com.himmu.blog.service;

import java.util.List;

import com.himmu.blog.dto.PostDTO;


public interface PostService {
	
	// create 
	PostDTO createPost(PostDTO postdto , Integer userId , Integer catId);
	
	// update 
	PostDTO updatePost(PostDTO postdto , Integer postId);
	
	// deleted
	void deletePost(Integer postId);
	
	// get all post
	List<PostDTO> getAllPosts();
	
	// get single post
	PostDTO getSinglePost(Integer postId);
	
	
	// get all post by uses
	List<PostDTO> getAllPostByUser(Integer userId);
	
	
	// get all post by categories
	List<PostDTO> getAllPostByCategory(Integer categoryId);
	
    
	
	
	

}
