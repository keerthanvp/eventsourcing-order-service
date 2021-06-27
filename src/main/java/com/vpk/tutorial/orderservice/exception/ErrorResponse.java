package com.vpk.tutorial.orderservice.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int errorCode;
	private String message;
	private String requestURI;

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", message=" + message + ", requestURI=" + requestURI + "]";
	}

}
