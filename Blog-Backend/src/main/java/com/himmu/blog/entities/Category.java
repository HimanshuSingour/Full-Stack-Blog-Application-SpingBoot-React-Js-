package com.himmu.blog.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories_tables")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(name = "Titles")
	private String categoryTitle;
	
	@Column(name = "Discription")
	private String categoryDiscription;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();
	
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
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

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDiscription="
				+ categoryDiscription + "]";
	}

	public Category(Integer categoryId, String categoryTitle, String categoryDiscription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDiscription = categoryDiscription;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
}
