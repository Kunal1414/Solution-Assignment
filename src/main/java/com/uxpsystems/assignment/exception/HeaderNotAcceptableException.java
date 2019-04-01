package com.uxpsystems.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class HeaderNotAcceptableException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HeaderNotAcceptableException(String exception) {
		super(exception);
	}
}
