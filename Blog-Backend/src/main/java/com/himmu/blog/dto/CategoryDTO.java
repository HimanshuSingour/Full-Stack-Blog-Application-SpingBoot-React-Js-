package com.himmu.blog.dto;


public class CategoryDTO {
	
	
	private int categoryId;
	private String categoryTitle;
	private String categoryDiscription;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	public CategoryDTO(int categoryId, String categoryTitle, String categoryDiscription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDiscription = categoryDiscription;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDiscription="
				+ categoryDiscription + "]";
	}
	
	
	

}
