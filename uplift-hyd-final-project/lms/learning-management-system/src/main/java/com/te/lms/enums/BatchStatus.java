package com.te.lms.enums;

public enum BatchStatus {
	INPROGRESS("INPROGRESS"),COMPLETED("COMPLETED"),TOBESTARTED("TOBESTARTED");
	
	private final String batchStatus;

	private BatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getBatchStatus() {
		return batchStatus;
	}
	
	
}
