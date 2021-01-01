package com.revature.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends AbstractHttpException {

	public UserNotFoundException(String message, int statusCode) {
	
		super(message, statusCode);
		
	}

}
