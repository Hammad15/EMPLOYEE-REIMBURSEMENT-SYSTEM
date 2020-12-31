package com.revature.exceptions;

@SuppressWarnings("serial")
public class InvalidStatusTypeException extends AbstractHttpException {

	public InvalidStatusTypeException(String message, int statusCode) {
		super(message, statusCode);
		// TODO Auto-generated constructor stub
	}
		
}
