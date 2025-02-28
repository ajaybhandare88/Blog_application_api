package com.project.api.blog.helper;

public class RoleDto {
	
	private int id;
	private String role;
	public RoleDto(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", role=" + role + "]";
	}
	
	

}
