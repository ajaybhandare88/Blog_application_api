package com.project.api.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.blog.helper.UserDto;
import com.project.api.blog.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/new/user")
public class PublicController {
	
	@Autowired
	UserServices userServices;
	
	@PostMapping("/")
	public UserDto createUser(@Valid @RequestBody UserDto userDto,@RequestParam(value="roleId",required = false,defaultValue = "2")int roleId)
	{
		return userServices.createUser(userDto,roleId);
	}

}
