package com.cassini.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cassini.flightbooking.dto.ErrorDto;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DateNotFoundException.class)
	public ResponseEntity<ErrorDto> dateNotFoundException(DateNotFoundException e){
		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(e.getMessage());
		errorDto.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
	}
	
	
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseEntity<ErrorDto> locationNotFoundException(LocationNotFoundException e){
		ErrorDto errorDto = new ErrorDto();
		errorDto.setMessage(e.getMessage());
		errorDto.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
	}
	
	
	/**
	 * 
	 * @param exception this is the parameter for handleUserNotFoundException method
	 * @return exception details
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> recordNotFoundException(RecordNotFoundException exception) {

		ErrorDto errorResponse = new ErrorDto();
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> nullPointerException(NullPointerException exception) {

		ErrorDto errorResponse = new ErrorDto();
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
}