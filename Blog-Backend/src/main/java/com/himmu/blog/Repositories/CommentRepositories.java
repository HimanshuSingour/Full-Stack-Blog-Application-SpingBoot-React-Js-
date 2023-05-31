package com.himmu.blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himmu.blog.entities.Comment;

public interface CommentRepositories extends JpaRepository<Comment, Integer> {

}
