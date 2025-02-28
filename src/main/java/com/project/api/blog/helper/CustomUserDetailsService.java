package com.project.api.blog.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.api.blog.dao.UserRepo;
import com.project.api.blog.entity.User;
import com.project.api.blog.exceptions.ResourceNotFound;


public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepo.findByEmail(username);
		if (user == null) {
            // Throws an exception if the user is not found
            throw new UsernameNotFoundException("User not found");
        }
		CustomUserDetails userDetails=new CustomUserDetails(user);
		return userDetails;
	}

}
