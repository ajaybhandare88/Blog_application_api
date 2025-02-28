package com.project.api.blog.helper;

public class ApiExceptions {

	private String message;
	private boolean result;
	public ApiExceptions(String message, boolean result) {
		super();
		this.message = message;
		this.result = result;
	}
	public ApiExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ApiExceptions [message=" + message + ", result=" + result + "]";
	}
	
	
	
}
