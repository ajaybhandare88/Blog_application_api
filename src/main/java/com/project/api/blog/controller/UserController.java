package com.project.api.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.blog.helper.ApiExceptions;
import com.project.api.blog.helper.UserDto;
import com.project.api.blog.helper.UserPaginationDetails;
import com.project.api.blog.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserServices userServices;
	
	
	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable("id") int id)
	{
		UserDto userDto=userServices.findById(id);
		
		return userDto;
	}
	
	@PutMapping("/{id}")
	public UserDto updateUser(@RequestBody UserDto userDto,@PathVariable ("id") int id,@RequestParam(value="roleId",required = false,defaultValue = "2")int roleId)
	{
		UserDto updatedUser=userServices.updateUser(userDto, id,roleId);
		return updatedUser;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiExceptions> deleteUser(@PathVariable("id") int id)
	{
		userServices.deleteUser(id);
		ApiExceptions sms=new ApiExceptions();
		sms.setMessage("user delete successfully");
		sms.setResult(true);
		return new ResponseEntity<ApiExceptions>(sms,HttpStatus.OK);
	}
	
	@GetMapping("/page")
	public ResponseEntity<UserPaginationDetails> findAll(@RequestParam(value = "pageNumber",defaultValue = "0",required = false)int pageNumber,@RequestParam(value = "pageSize",defaultValue = "4",required = false)int pageSize)
	{
		UserPaginationDetails alluser=userServices.findByAll(pageNumber,pageSize);
		return new ResponseEntity<UserPaginationDetails>(alluser,HttpStatus.FOUND);
	}
	
	@PostMapping("/addNewRole")
	public ResponseEntity<UserDto> addRole(@RequestParam(value = "userId",required = true)int userId,@RequestParam(value = "roleId",required = true)int roleId)
	{
		return new ResponseEntity<UserDto>(userServices.addNewRole(userId, roleId),HttpStatus.UPGRADE_REQUIRED);
	}

}
