package com.himmu.blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himmu.blog.entities.Category;

public interface CategoryRepositories extends JpaRepository<Category, Integer>{

}
