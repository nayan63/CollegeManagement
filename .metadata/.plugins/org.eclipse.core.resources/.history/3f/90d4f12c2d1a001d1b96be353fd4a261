package com.mindtree.student.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionResponse extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleUserAllException(Exception e,WebRequest wr)
	{
		ResponseException er = new ResponseException(new Date(),e.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<Object>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentFullException.class)
	public final ResponseEntity<Object> handleNotFoundException(StudentFullException e,WebRequest wr)
	{
		ResponseException er = new ResponseException(new Date(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,WebRequest wr)
	{
		ResponseException er = new ResponseException(new Date(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<Object>(er,HttpStatus.BAD_REQUEST);
	}
	
}

