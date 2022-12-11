package com.te.lms.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponse<T> {
	private String message;
	private T data;
	private LocalDateTime timeStamp = LocalDateTime.now();
	
	public RegistrationResponse(String message) {
		super();
		this.message = message;
	}

	public RegistrationResponse(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}
	
	
	
	
}
