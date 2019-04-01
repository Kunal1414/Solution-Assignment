package com.uxpsystems.assignment.exception;

public class AssignmentException extends Exception {

	private static final long serialVersionUID = 7298374695689826687L;

	public AssignmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssignmentException(String message) {
		super(message);
	}

	public AssignmentException(Throwable cause) {
		super(cause);
	}

}
