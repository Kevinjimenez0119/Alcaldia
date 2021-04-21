package com.app.plantillalogin.api.utils;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	private HttpStatus status;

	public ValidationException(String msg, HttpStatus status) {
		this.msg =  msg ;
		this.status = status;		
	}

	public String getMsg() {
		return msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
