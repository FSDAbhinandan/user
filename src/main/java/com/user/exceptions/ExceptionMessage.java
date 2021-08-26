package com.user.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {
	
	private String message;
	private LocalDateTime dt;
	private HttpStatus status;
	public ExceptionMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ExceptionMessage(String message, HttpStatus status) {
		super();
		this.message = message;
		this.dt = LocalDateTime.now();
		this.status = status;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDt() {
		return dt;
	}
	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "ExceptionMessage [message=" + message + ", dt=" + dt + ", status=" + status + "]";
	}
	
	
	
	

}
