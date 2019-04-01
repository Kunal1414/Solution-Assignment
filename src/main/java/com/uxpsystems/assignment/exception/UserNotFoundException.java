package com.uxpsystems.assignment.exception;

public class UserNotFoundException extends AssignmentException {

	private static final long serialVersionUID = 5903631054312587484L;

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

}
