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
@Table(name = "Users_table")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Passwords")
	private String password;
	
	@Column(name = "About")
	private String about;
	

	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
				+ ", posts=" + posts + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getAbout()=" + getAbout() + ", getPosts()="
				+ getPosts() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Users(Integer id, String name, String email, String password, String about, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.posts = posts;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
