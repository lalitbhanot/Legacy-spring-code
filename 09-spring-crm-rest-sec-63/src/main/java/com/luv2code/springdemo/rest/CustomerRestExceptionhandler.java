package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionhandler {
	
	//Add the exception 
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exe)
	{
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND) ;
	}
	
	//Generic Exception 
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exe)
	{
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST) ;
	}
}
