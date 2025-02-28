package com.project.api.blog.helper;

import java.util.Date;
import java.util.List;

import com.project.api.blog.entity.Category;
import com.project.api.blog.entity.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class PostDto {
	
	private int id;
	@NotEmpty
	@Size(min = 1, max = 10,message = "Post title reqired between 1 to 10")
	private String title;
	@NotEmpty
	@Size(min = 1, max = 10,message = "Post content reqired between 1 to 10")
	private String content;
	private String imageName;
	private Date addedDate;
	
	private CategoryDto category;
	private UserDto user;
	private List<CommentDto> comment;
	public PostDto(int id,
			@NotEmpty @Size(min = 1, max = 10, message = "Post title reqired between 1 to 10") String title,
			@NotEmpty @Size(min = 1, max = 10, message = "Post content reqired between 1 to 10") String content,
			String imageName, Date addedDate, CategoryDto category, UserDto user, List<CommentDto> comment) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.comment = comment;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public List<CommentDto> getComment() {
		return comment;
	}
	public void setComment(List<CommentDto> comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", category=" + category + ", user=" + user + ", comment=" + comment
				+ "]";
	}
	
	
	
	

}
