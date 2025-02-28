package com.project.api.blog.helper;

import java.util.List;

import com.project.api.blog.entity.Post;
import com.project.api.blog.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {

	private int id;
	
	@NotEmpty(message = "User name is required")
	@Size(min = 4,max = 30,message = "Minumun 4 char and max 10 char required")
	private String name;
	@Email(message = "Enter valid email id")
	private String email;
	@NotEmpty(message = "Password is must")
	@Size(min = 4,max = 50,message = "Minumun 4 char and max 10 char required")
	private String password;
	@NotEmpty
	@Size(min = 4,max = 50,message = "Minumun 4 char and max 10 char required")
	private String abouts;
	
	private List<Role> role;

	
	public UserDto(int id,
			@NotEmpty(message = "User name is required") @Size(min = 4, max = 30, message = "Minumun 4 char and max 10 char required") String name,
			@Email(message = "Enter valid email id") String email,
			@NotEmpty(message = "Password is must") @Size(min = 4, max = 50, message = "Minumun 4 char and max 10 char required") String password,
			@NotEmpty @Size(min = 4, max = 50, message = "Minumun 4 char and max 10 char required") String abouts,
			List<Role> role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.abouts = abouts;
		this.role = role;
	}


	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", abouts="
				+ abouts + ", role=" + role + "]";
	}



	
	
	
	
}
