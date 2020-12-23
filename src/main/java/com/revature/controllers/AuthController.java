package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.LoginService;


public class AuthController {
	
	private LoginService login = new LoginService();
	
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException, UserNotFoundException, InternalErrorException {
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		User u = login.login(cred.getUsername(), cred.getPassword());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
	}
	
	
	

}