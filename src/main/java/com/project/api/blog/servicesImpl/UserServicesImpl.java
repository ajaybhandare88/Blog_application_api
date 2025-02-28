package com.project.api.blog.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.api.blog.dao.UserRepo;
import com.project.api.blog.dao.UserRoleRepo;
import com.project.api.blog.entity.Role;
import com.project.api.blog.entity.User;
import com.project.api.blog.exceptions.ResourceNotFound;
import com.project.api.blog.helper.UserDto;
import com.project.api.blog.helper.UserPaginationDetails;
import com.project.api.blog.services.UserServices;


@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserRoleRepo roleRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	ModelMapper modelmapper;

	@Override
	public UserDto createUser(UserDto userDto,int roleId) {
		User user=this.userDtoToUser(userDto);
		List<Role> roleList=new ArrayList<Role>();
		Role findRole=roleRepo.findById(roleId);
		if(findRole==null)
		{
			throw new ResourceNotFound("User"," id ",1);
		}
		roleList.add(findRole);
		user.setRole(roleList);
		user.setPassword(bCryptPasswordEncoder.encode("password"));
		User createdUser=this.userRepo.save(user);
		UserDto resultReturn=this.userToUserDto(createdUser);
		return resultReturn;
	}

	@Override
	public UserDto findById(int id) {
		
		
		User user=this.userRepo.findById(id);
		
		if(user==null)
		{
			throw new ResourceNotFound("User"," id ",id);
		}
		
		UserDto resultReturn=this.userToUserDto(user);
		return resultReturn;
		
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, int id,int roleId) {
		
		User user=this.userRepo.findById(id);
		List<Role> roleList=new ArrayList<Role>();
		if(user==null)
		{
			throw new ResourceNotFound("User"," id ",id);
		}
		Role findRole=roleRepo.findById(roleId);
		if(findRole==null)
		{
			throw new ResourceNotFound("User"," id ",1);
		}
		roleList.add(findRole);
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbouts(userDto.getAbouts());
		user.setPassword(userDto.getPassword());
		user.setRole(roleList);
		
		User updateUser=this.userRepo.save(user);
		
		return this.userToUserDto(updateUser);
	}

	@Override
	public void deleteUser(int id) {
		User user=userRepo.findById(id);
		if(user==null)
		{
			throw new ResourceNotFound("User"," id ",id);
		}
		this.userRepo.delete(user);
		
	}
	
	@Override
	public UserPaginationDetails findByAll(int pageNumber,int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNumber,pageSize);
		Page<User> allUser=userRepo.findAll(pageable);
		List<UserDto> userList=new ArrayList<UserDto>();
		allUser.getContent().forEach((user)->{
			userList.add(userToUserDto(user));
		});
		
		UserPaginationDetails paginationDetails=new UserPaginationDetails();
		paginationDetails.setListOfUserDto(userList);
		paginationDetails.setTotalPageNumber(allUser.getTotalPages());
		paginationDetails.setPageDataValue(allUser.getSize());
		paginationDetails.setLast(allUser.isLast());
		paginationDetails.setCurrentPageNumber(allUser.getNumber());
		
		return paginationDetails;
	}
	
	
	public UserDto userToUserDto(User user)
	{
		UserDto dto=modelmapper.map(user,UserDto.class);
		return dto;
	}
	
	public User userDtoToUser(UserDto userDto)
	{
		User user=modelmapper.map(userDto,User.class);
		return user;
	}

	@Override
	public UserDto addNewRole(int userId, int roleId) {
		User user=userRepo.findById(userId);
		Role findRole=roleRepo.findById(roleId);
		if(user==null)
		{
			throw new ResourceNotFound("User"," id ",userId);
		}
		if(findRole==null)
		{
			throw new ResourceNotFound("User"," id ",1);
		}
		user.getRole().forEach((role)->{
			if(role.equals(findRole))
			{
				throw new ResourceNotFound(role.getRole());
			}
		});
		user.getRole().add(findRole);
		userRepo.save(user);
		return modelmapper.map(user, UserDto.class);
	}

	
	
	
	

}
