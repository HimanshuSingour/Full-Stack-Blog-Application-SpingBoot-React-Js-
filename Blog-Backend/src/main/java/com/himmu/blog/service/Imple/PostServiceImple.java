package com.himmu.blog.service.Imple;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himmu.blog.Expections.ResourseNotFoundExceptions;
import com.himmu.blog.Repositories.CategoryRepositories;
import com.himmu.blog.Repositories.PostRepositories;
import com.himmu.blog.Repositories.UserRepository;
import com.himmu.blog.dto.PostDTO;
import com.himmu.blog.entities.Category;
import com.himmu.blog.entities.Post;
import com.himmu.blog.entities.Users;
import com.himmu.blog.service.PostService;

@Service
public class PostServiceImple implements PostService {
	
	@Autowired
	private PostRepositories postRepositories;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private CategoryRepositories categoryrepository;

	@Override
	public PostDTO createPost(PostDTO postdto , Integer userId , Integer catId) {
		
		Users user = userrepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("user" , "userId" , userId));
		
		Category category = categoryrepository.findById(catId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("category" , "categoryId" , catId));
		
		Post post = dtoToPost(postdto);
		post.setPostImageName("Default.img");
		post.setPostAddedData(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newpost = postRepositories.save(post);
		return postToDTO(newpost);
		
	}

	@Override
	public PostDTO updatePost(PostDTO postdto, Integer postId) {
		
	    Post post = dtoToPost(postdto);
	    Post findPost = postRepositories.findById(postId)
	    		.orElseThrow(() -> new ResourseNotFoundExceptions("post" , "postId" , postId));
	    
	    findPost.setPostTitle(postdto.getPostTitle());
	    findPost.setPostContent(postdto.getPostContent());
	    PostDTO postDTO = postToDTO(findPost);
		return postDTO;
	}

	@Override
	public void deletePost(Integer postId) {
		Post deletedPost = postRepositories.findById(postId).
			  orElseThrow(() -> new ResourseNotFoundExceptions("post" , "postId" , postId));
		 postRepositories.delete(deletedPost);

	}

	@Override
	public List<PostDTO> getAllPosts() {
		List<Post> all = postRepositories.findAll();
		List<PostDTO> allOne = all.stream().map(e -> postToDTO(e)).collect(Collectors.toList());
		return allOne;
	}

	@Override
	public PostDTO getSinglePost(Integer postId) {
		Post postdto = postRepositories.findById(postId).
				  orElseThrow(() -> new ResourseNotFoundExceptions("post" , "postId" , postId));
		
		return postToDTO(postdto);
	}
	
	// New Learning....
	@Override
	public List<PostDTO> getAllPostByUser(Integer userId) {
		Users user = userrepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("post" , "postId" , userId));
		
		return null;
	}

	@Override
	public List<PostDTO> getAllPostByCategory(Integer categoryId) {
		Category cat = categoryrepository.findById(categoryId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("category" , "categoryId" , categoryId));
		
		List<Post> cate = postRepositories.findAllByCategory(cat);
		List<PostDTO> postdto = cate.stream().map((e) -> postToDTO(e)).collect(Collectors.toList());
		return postdto;
	}
	
	
	// Conversion DTO to Post and vice-versa
	public Post dtoToPost(PostDTO postdto) {
		
		Post post = new Post();
		post.setPostTitle(postdto.getPostTitle());
		post.setPostContent(postdto.getPostContent());
		return post;
		
	}
	
	public PostDTO postToDTO(Post post) {
		
		PostDTO p = new PostDTO();
		p.setPostTitle(post.getPostTitle());
		p.setPostContent(post.getPostContent());
		return p;
		
	}
	
}
