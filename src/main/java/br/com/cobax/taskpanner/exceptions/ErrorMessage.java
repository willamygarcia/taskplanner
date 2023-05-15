package br.com.cobax.taskpanner.exceptions;

import java.time.Instant;

public class ErrorMessage {
	
	private Integer status;
	private Instant timestamp;
	private String message;
	private String details;
	
	public ErrorMessage() {
	}
	
	public ErrorMessage(Integer status, Instant timestamp, String message, String details) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
