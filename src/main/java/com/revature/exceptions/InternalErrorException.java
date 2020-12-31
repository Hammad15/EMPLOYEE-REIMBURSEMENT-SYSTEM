package com.revature.exceptions;

@SuppressWarnings("serial")
public class InternalErrorException extends AbstractHttpException {

	public InternalErrorException(String message, int statusCode) {
		super(message, statusCode);
		// TODO Auto-generated constructor stub
	}
	
}
	
