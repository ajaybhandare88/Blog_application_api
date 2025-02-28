package com.project.api.blog.exceptions;

public class ResourceNotFound extends RuntimeException{
	
	public String resourcename;
	public String fildname;
	public int value;
	
	public ResourceNotFound(String resourcename, String fildname, int value) {
		super(String.format("%s not found with %s : %s",resourcename,fildname,value));
		this.resourcename = resourcename;
		this.fildname = fildname;
		this.value = value;
	}
	public ResourceNotFound(String resourcename) {
		super(String.format("%s this role you have already",resourcename));
		this.resourcename = resourcename;
	}
	

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFildname() {
		return fildname;
	}

	public void setFildname(String fildname) {
		this.fildname = fildname;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
	
	
	

}
