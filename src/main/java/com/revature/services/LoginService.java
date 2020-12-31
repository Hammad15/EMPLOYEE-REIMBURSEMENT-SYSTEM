package com.revature.services;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;

public class LoginService {
	
	UserDAO userDAO = new UserPostgresDAO();
	
	public User login(String username, String password) throws UserNotFoundException, InternalErrorException {
		
		return userDAO.findUserByUsernameAndPassword(username, password); 
		
	}

}
