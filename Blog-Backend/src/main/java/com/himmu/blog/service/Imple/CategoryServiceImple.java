package com.himmu.blog.service.Imple;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himmu.blog.Expections.ResourseNotFoundExceptions;
import com.himmu.blog.Repositories.CategoryRepositories;
import com.himmu.blog.dto.CategoryDTO;
import com.himmu.blog.entities.Category;
import com.himmu.blog.service.CategoryService;

@Service
public class CategoryServiceImple implements CategoryService {

	@Autowired
	private CategoryRepositories categoryrepositories;
	
	
	@Override
	public CategoryDTO createCategory(CategoryDTO cateDTO) {
		
		 Category category = dtoToCategory(cateDTO);
		 Category savingCategory = categoryrepositories.save(category);
		 return categoryToDto(savingCategory);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO cateDTO, Integer cateId) {
		
		Category cat = categoryrepositories.findById(cateId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("category" , "category Id" , cateId));
		cat.setCategoryTitle(cateDTO.getCategoryTitle());
		cat.setCategoryDiscription(cateDTO.getCategoryDiscription());
		
		Category updatedOne = categoryrepositories.save(cat);
		return categoryToDto(updatedOne);
	}

	@Override
	public CategoryDTO getCategoryById(Integer cateId) {
	  Category cat = categoryrepositories.getById(cateId);
	   return categoryToDto(cat);
	}

	@Override
	public void deletCategroy(Integer cateId) {
		Category cat = categoryrepositories.findById(cateId).orElseThrow(() -> new ResourseNotFoundExceptions("category" , "categoryId" , cateId));
		categoryrepositories.delete(cat);
		
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> cat = categoryrepositories.findAll();
		List<CategoryDTO> categoryDto = cat.stream().map(e -> categoryToDto(e)).collect(Collectors.toList());
		return categoryDto;
	}
	
	
	// Convert DTO to Category and vice versa
	
	public Category dtoToCategory(CategoryDTO cateDto) {
		
		Category s = new Category();
		s.setCategoryTitle(cateDto.getCategoryTitle());
		s.setCategoryDiscription(cateDto.getCategoryDiscription());
		return s;
		
	}
	
	public CategoryDTO categoryToDto(Category categ) {
		
		CategoryDTO ss = new CategoryDTO();
		ss.setCategoryTitle(categ.getCategoryTitle());
		ss.setCategoryDiscription(categ.getCategoryDiscription());
		return ss;
		
	}

}
