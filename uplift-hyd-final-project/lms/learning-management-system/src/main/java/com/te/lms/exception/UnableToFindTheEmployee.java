package com.te.lms.exception;

public class UnableToFindTheEmployee extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnableToFindTheEmployee(String message) {
		super(message);
	}
}
