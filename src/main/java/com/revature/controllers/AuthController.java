package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		System.out.println("Setting attribute\n" + u);
		
		HttpSession session = req.getSession(true);
		System.out.println(session.getId());
			
		session.setAttribute("User", u);
		session.setAttribute("UserRole", u.getUserRole());
		
		System.out.println(session.getAttribute("User"));
		System.out.println(session.getAttribute("username"));
		System.out.println(session.getAttribute("UserRole"));
		System.out.println((String)session.getAttribute("UserRole"));
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
	}

}