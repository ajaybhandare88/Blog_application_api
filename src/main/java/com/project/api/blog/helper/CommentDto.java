package com.project.api.blog.helper;


public class CommentDto {

	private int id;
	private String content;
	private UserDto user;
	
	public CommentDto(int id, String content,UserDto user) {
		super();
		this.id = id;
		this.content = content;
		this.user=user;
	}
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user= user;
	}
	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", content=" + content + "]";
	}
	
	
	
}
