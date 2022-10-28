package com.cts.blogging.exception;

import java.time.LocalDateTime;

public class CustomErrorResponse {

	private int id;
	private String message; 
	private LocalDateTime dateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public CustomErrorResponse(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}
	public CustomErrorResponse() {
		super();
	}
	@Override
	public String toString() {
		return "CustomErrorResponse [message=" + message + ", dateTime=" + dateTime + "]";
	}
}
