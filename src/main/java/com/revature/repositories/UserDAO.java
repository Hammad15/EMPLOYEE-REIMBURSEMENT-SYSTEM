package com.revature.repositories;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserDAO {
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	

}
