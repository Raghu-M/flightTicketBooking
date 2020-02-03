package com.cassini.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	/**
	 * 
	 * @param exception this is the parameter for handleUserNotFoundException method
	 * @return exception details
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> recordNotFoundException(RecordNotFoundException exception) {

		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> nullPointerException(NullPointerException exception) {

		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
}