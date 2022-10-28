package com.cts.blogging.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TokenNotValidException.class)
	public ResponseEntity<CustomErrorResponse> tokenNotValidHandler(TokenNotValidException tokenNotValidException){
		CustomErrorResponse customErrorResponse= new CustomErrorResponse(tokenNotValidException.getMessage(),LocalDateTime.now());
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> userNotFoundHandler(UserNotFoundException userNotFoundException){
		CustomErrorResponse customErrorResponse= new CustomErrorResponse(userNotFoundException.getMessage(),LocalDateTime.now());
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse,HttpStatus.NOT_FOUND);
		
	}
}
