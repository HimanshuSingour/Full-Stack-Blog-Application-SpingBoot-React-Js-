package com.himmu.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himmu.blog.dto.ApiResponse;
import com.himmu.blog.dto.PostDTO;
import com.himmu.blog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/create/user/{userId}/category/{catId}/posts")
	public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO postdto,
			@PathVariable Integer userId ,@PathVariable Integer catId){
		
	PostDTO createdPost = postService.createPost(postdto , userId , catId);
	  return new ResponseEntity<PostDTO>(createdPost, HttpStatus.CREATED);
	
	}
	
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDTO> updatesPost(@RequestBody PostDTO postdto , Integer postId){
		PostDTO pdto = postService.updatePost(postdto, postId);
		return new ResponseEntity<PostDTO>(pdto , HttpStatus.OK);	
	}
	
	@DeleteMapping("delet/{postId}")
	public ResponseEntity<ApiResponse> deletedPost(@PathVariable Integer postId){
		postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("this post has been deleted" , true) , HttpStatus.OK);	
		
	}

	@GetMapping("/all")
	public ResponseEntity<List<PostDTO>> getAllPostS(){
		List<PostDTO> listpost = postService.getAllPosts();
		return new ResponseEntity<List<PostDTO>>(listpost , HttpStatus.OK);	

   }
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDTO> getSinglePost(@PathVariable Integer postId){
		PostDTO postdto = postService.getSinglePost(postId);
		return new ResponseEntity<PostDTO>(postdto , HttpStatus.OK);	
	 }
	
	// New Learning....
	@GetMapping("/all/{userId}/posts")
	public ResponseEntity<List<PostDTO>> getallpostbyusers(@PathVariable Integer userId){
		List<PostDTO> post = postService.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDTO>>(post , HttpStatus.OK);	
		
	}
	
	@GetMapping("/all/{catId}/posts")
	public ResponseEntity<List<PostDTO>> getAlluserByCategories(@PathVariable Integer catId){
		List<PostDTO> post = postService.getAllPostByCategory(catId);
		return new ResponseEntity<List<PostDTO>>(post , HttpStatus.OK);		
	}
}
