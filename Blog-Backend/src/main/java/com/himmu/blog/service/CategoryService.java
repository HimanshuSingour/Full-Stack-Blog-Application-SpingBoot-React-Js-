package com.himmu.blog.service;


import java.util.List;

import com.himmu.blog.dto.CategoryDTO;

public interface CategoryService {
	
	//create
	CategoryDTO createCategory(CategoryDTO cateDTO);
	
	//update
	CategoryDTO updateCategory(CategoryDTO cateDTO , Integer cateId);
	
	//get
	
	CategoryDTO getCategoryById(Integer cateId);
	
	//delet
	void deletCategroy(Integer cateId);
	
	// get all category
	
	List<CategoryDTO> getAllCategory();
	

}
