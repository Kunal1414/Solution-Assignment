package com.uxpsystems.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> UserNotFound(UserNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("User Not Found", "404");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = AssignmentException.class)
	public final ResponseEntity<ExceptionResponse> forAssignmentException(AssignmentException ex, String message) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(message, "400");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BadRequestException.class)
	public final ResponseEntity<ExceptionResponse> forBadRequest(BadRequestException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Bad request", "400");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = HeaderNotAcceptableException.class)
	public final ResponseEntity<ExceptionResponse> handleHeaderNotAcceptableException(HeaderNotAcceptableException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Request Header is not acceptable", "406");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Please contact admin", "500");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
