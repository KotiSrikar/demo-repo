package com.te.lms.enums;

public enum Status {
	INPROGRESS("INPROGRESS"),COMPLETED("COMPLETED"),TOBESTARTED("TOBESTARTED");
	
	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
}
