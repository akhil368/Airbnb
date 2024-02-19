package com.airbnb.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> globalException(WebRequest wb, Exception ex)
	{
		MyErrorDetails err=new MyErrorDetails(ex.getMessage(),wb.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AirBnbException.class)
	public ResponseEntity<MyErrorDetails> airBnbException(WebRequest wb,AirBnbException ex)
	{
		MyErrorDetails err=new MyErrorDetails(ex.getMessage(),wb.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> notFoundException(WebRequest wb,NotFoundException ex)
	{
		MyErrorDetails err=new MyErrorDetails(ex.getMessage(),wb.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullException.class)
	public ResponseEntity<MyErrorDetails> NullException(WebRequest wb,NullException ex)
	{
		MyErrorDetails err=new MyErrorDetails(ex.getMessage(),wb.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
}
