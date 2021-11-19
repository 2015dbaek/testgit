package com.apolis.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InputMissingException.class)
	public ResponseEntity<ExceptionResponse> handleException(InputMissingException ex){
		ExceptionResponse exR = new ExceptionResponse("No data is found within database with this object", "708", new Date());
		return new ResponseEntity<ExceptionResponse>(exR, HttpStatus.BAD_REQUEST);
	}
	
}
