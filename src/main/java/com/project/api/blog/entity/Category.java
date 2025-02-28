package com.project.api.blog.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryID;
	
	private String categoryTitle;
	private String categoryDescriptions;
	
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Post> post;

	public Category(int categoryID, String categoryTitle, String categoryDescriptions, List<Post> post) {
		super();
		this.categoryID = categoryID;
		this.categoryTitle = categoryTitle;
		this.categoryDescriptions = categoryDescriptions;
		this.post = post;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescriptions() {
		return categoryDescriptions;
	}

	public void setCategoryDescriptions(String categoryDescriptions) {
		this.categoryDescriptions = categoryDescriptions;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryTitle=" + categoryTitle + ", categoryDescriptions="
				+ categoryDescriptions + ", post=" + post + "]";
	}
	
	
}
