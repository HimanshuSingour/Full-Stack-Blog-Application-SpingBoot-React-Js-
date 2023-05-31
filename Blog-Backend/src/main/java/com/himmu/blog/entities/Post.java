package com.himmu.blog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_table")
public class Post {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@Column(name = "Title")
	private String postTitle;
	
	@Column(name = "Content")
	private String postContent;
	
	@Column(name = "Image")
	private String postImageName;
	
	@Column(name = "Date")
	private Date postAddedData;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	private Users user;
	
	@OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postImageName=" + postImageName + ", postAddedData=" + postAddedData + ", category=" + category
				+ ", user=" + user + ", getPostId()=" + getPostId() + ", getPostTitle()=" + getPostTitle()
				+ ", getPostContent()=" + getPostContent() + ", getPostImageName()=" + getPostImageName()
				+ ", getPostAddedData()=" + getPostAddedData() + ", getCategory()=" + getCategory() + ", getUser()="
				+ getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Post(Integer postId, String postTitle, String postContent, String postImageName, Date postAddedData,
			Category category, Users user) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImageName = postImageName;
		this.postAddedData = postAddedData;
		this.category = category;
		this.user = user;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
}
