package com.himmu.blog.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.himmu.blog.entities.Comment;

public class PostDTO {
	
	private String postTitle;
	private String postContent;
	private String postImageName;
	private Date postAddedData;
	
	private CategoryDTO category;
	private UserDTO user;
	
	private List<Comment> comment = new ArrayList<Comment>();

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostImageName() {
		return postImageName;
	}

	public void setPostImageName(String postImageName) {
		this.postImageName = postImageName;
	}

	public Date getPostAddedData() {
		return postAddedData;
	}

	public void setPostAddedData(Date postAddedData) {
		this.postAddedData = postAddedData;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostDTO [postTitle=" + postTitle + ", postContent=" + postContent + ", postImageName=" + postImageName
				+ ", postAddedData=" + postAddedData + ", category=" + category + ", user=" + user + ", getPostTitle()="
				+ getPostTitle() + ", getPostContent()=" + getPostContent() + ", getPostImageName()="
				+ getPostImageName() + ", getPostAddedData()=" + getPostAddedData() + ", getCategory()=" + getCategory()
				+ ", getUser()=" + getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public PostDTO(String postTitle, String postContent, String postImageName, Date postAddedData, CategoryDTO category,
			UserDTO user) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImageName = postImageName;
		this.postAddedData = postAddedData;
		this.category = category;
		this.user = user;
	}

	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
