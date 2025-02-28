package com.project.api.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.api.blog.helper.ApiExceptions;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiExceptions> resourceNotFound(ResourceNotFound ex)
	{
		String message=ex.getMessage();
		ApiExceptions e=new ApiExceptions(message,false);
		return new ResponseEntity<ApiExceptions>(e,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((errors)->{
			String fildName=((FieldError)errors).getField();
			String message=errors.getDefaultMessage();
			resp.put(fildName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<Map<String, String>> usernameNotFoundException(UsernameNotFoundException ex)
	{
		Map<String,String> resp=new HashMap<>();
		
			resp.put(ex.getCause().toString(), ex.getMessage().toString());
	
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_GATEWAY);
	}
	
	

}
