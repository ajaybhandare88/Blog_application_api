package com.project.api.blog.helper;

import java.util.List;

import com.project.api.blog.entity.Post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	private int categoryID;
	
	@NotEmpty
	@Size(min = 1, max = 10,message = "Category title reqired between 1 to 10")
	private String categoryTitle;
	@NotEmpty
	@Size(min = 1, max = 10,message = "Category discreption reqired between 1 to 10")
	private String categoryDescriptions;
	public CategoryDto(int categoryID,
			@NotEmpty @Size(min = 1, max = 10, message = "Category title reqired between 1 to 10") String categoryTitle,
			@NotEmpty @Size(min = 1, max = 10, message = "Category discreption reqired between 1 to 10") String categoryDescriptions
			) {
		super();
		this.categoryID = categoryID;
		this.categoryTitle = categoryTitle;
		this.categoryDescriptions = categoryDescriptions;
	}
	public CategoryDto() {
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
	
	@Override
	public String toString() {
		return "CategoryDto [categoryID=" + categoryID + ", categoryTitle=" + categoryTitle + ", categoryDescriptions="
				+ categoryDescriptions + "]";
	}
	
	
	
	
}
