package com.Blinkit.Blinkit.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> BadRequestExceptionHandler (BadRequestException badexception){
		return new ResponseEntity<String>(badexception.getMessage(),HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> ResourceNotFoundExceptionhandler(ResourceNotFoundException  ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<String> DuplicateResourceExceptionhandler(DuplicateResourceException exception){
		return new ResponseEntity<String> (exception.getMessage(),HttpStatus.CONFLICT);
	}

}
