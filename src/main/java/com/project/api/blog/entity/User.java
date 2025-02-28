package com.project.api.blog.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String abouts;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Comment> comment;

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Post> post;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Role> role=new ArrayList<Role>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, String password, String abouts, List<Comment> comment,
			List<Post> post, List<Role> role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.abouts = abouts;
		this.comment = comment;
		this.post = post;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getAbouts() {
		return abouts;
	}

	public void setAbouts(String abouts) {
		this.abouts = abouts;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", abouts="
				+ abouts + ", comment=" + comment + ", post=" + post + ", role=" + role + "]";
	}
	
	
}
