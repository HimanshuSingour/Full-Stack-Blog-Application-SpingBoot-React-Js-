package com.himmu.blog.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himmu.blog.entities.Category;
import com.himmu.blog.entities.Post;
import com.himmu.blog.entities.Users;

public interface PostRepositories extends JpaRepository<Post, Integer>{
	
	List<Post> findAllByUser(Users user);
	List<Post> findAllByCategory(Category category);
	
	

}
