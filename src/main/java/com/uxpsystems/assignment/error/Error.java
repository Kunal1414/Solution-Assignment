package com.uxpsystems.assignment.error;

public enum Error {

	INVALID_CREDENTIALS("E101", "Invalid Credentials"),
	USER_NOT_FOUND("E102", "User not found"),
	DUPLICATE_USER_NAME("E103", "User name already exists"),
	DEFAULT("E104", "Something went wrong");

	private final String code;
	private final String message;

	private Error(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "{ \"code\":\"" + this.code + "\",\"message\":\"" + this.message + "\"}";
	}
}
