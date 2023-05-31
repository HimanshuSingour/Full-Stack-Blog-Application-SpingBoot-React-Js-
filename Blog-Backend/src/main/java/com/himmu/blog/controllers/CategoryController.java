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
import com.himmu.blog.dto.CategoryDTO;
import com.himmu.blog.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
    public ResponseEntity<CategoryDTO> createC(@RequestBody CategoryDTO categoryDTO){
    	CategoryDTO cate = this.categoryService.createCategory(categoryDTO);
    	return new ResponseEntity<CategoryDTO>(cate , HttpStatus.CREATED);
    }
	
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoryDTO> updateC(@RequestBody CategoryDTO categoryDTO ,@PathVariable("catId") Integer catId){
		CategoryDTO cate = categoryService.updateCategory(categoryDTO, catId);
		return new ResponseEntity<CategoryDTO>(cate , HttpStatus.OK);
	}
	
	@GetMapping("/get/{catId}")
	public ResponseEntity<CategoryDTO> getById(@PathVariable("catId") Integer catId){
		CategoryDTO cate = categoryService.getCategoryById(catId);
		return new ResponseEntity<CategoryDTO>(cate , HttpStatus.OK);
	}
	
	@DeleteMapping("/delet/{catId}")
	public ResponseEntity<ApiResponse> deletbyId(@PathVariable("catId") Integer catId){
		categoryService.deletCategroy(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully" , false) , HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDTO>> getAll(){
		List<CategoryDTO> cat = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDTO>>(cat , HttpStatus.OK);
	}
}
