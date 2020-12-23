package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.LoginService;

@SuppressWarnings("serial")
public class AuthServlet extends HttpServlet{
	
	User us = new User();
	
	LoginService log = new LoginService();
	
	ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		System.out.println(cred.getUsername());
		System.out.println(cred.getPassword());
		
//		try {
//			us = log.login(cred.getUsername(), cred.getPassword());
//		} catch (UserNotFoundException e) {
//			System.out.println("User Not Found");
//			e.printStackTrace();
//		} catch (InternalErrorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(us);
		
		resp.setStatus(501);
		
	}

}
