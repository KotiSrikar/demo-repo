package com.te.lms.exception;

public class NoDataFoundInTheListException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoDataFoundInTheListException(String message) {
		super(message);
	}
}
