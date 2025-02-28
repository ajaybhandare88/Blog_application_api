package com.project.api.blog.services;

import java.util.List;

import com.project.api.blog.entity.Role;
import com.project.api.blog.helper.UserDto;
import com.project.api.blog.helper.UserPaginationDetails;

public interface UserServices {
	
	public UserDto createUser(UserDto userDto,int roleId);
	public UserDto findById(int id);
	public UserDto updateUser(UserDto userDto,int id,int roleId);
	public void deleteUser(int id);
	public UserPaginationDetails findByAll(int pageNumber,int pageSize);
	public UserDto addNewRole(int userId,int roleId);

}
