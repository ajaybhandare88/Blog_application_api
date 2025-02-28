package com.project.api.blog.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.api.blog.entity.User;
import com.project.api.blog.exceptions.ResourceNotFound;

public class CustomUserDetails implements UserDetails{
	
	private User user;
	
	public CustomUserDetails(User user)
	{
		
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	        
		 	for(int i=0; i<user.getRole().size(); i++) {
	        SimpleGrantedAuthority role1 = new SimpleGrantedAuthority(user.getRole().get(i).getRole());
	        roles.add(role1);
		 	}
	        
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

}
