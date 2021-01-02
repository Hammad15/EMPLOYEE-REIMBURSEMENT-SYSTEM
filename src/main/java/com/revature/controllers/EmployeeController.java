package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.EmployeeServices;

public class EmployeeController {

	private EmployeeServices es = new EmployeeServices();
	
	private ObjectMapper om = new ObjectMapper();
	

	public void submitReimbRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Reimbursement reimb = om.readValue(req.getInputStream(), Reimbursement.class);
		
		HttpSession session = req.getSession(false);
		System.out.println(session.getId());
		
		if(session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if(!session.getAttribute("UserRole").equals("employee")) {
			throw new UnauthorizedException();
		}
		
		User u = (User)session.getAttribute("User");
		
		System.out.println(u);
		
		es.submitRequest(u.getUserID(), reimb.getReimbAmount(), reimb.getReimbDescription(), reimb.getReimbReceipt(), reimb.getReimbType());
		
		res.setContentType("text/html");
		res.setStatus(200);
		res.getWriter().write("<p>The request has been submitted</p>");
		
	}
	
	public void checkReimbRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if(!session.getAttribute("UserRole").equals("employee")) {
			throw new UnauthorizedException();
		}
		
		User u = (User)req.getAttribute("User");
		
		String status = es.checkStatus(u.getUserID());
		
		res.setStatus(200);
		res.getWriter().write(status);
		
	}
	
	
	public void viewAllRequests(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if(!session.getAttribute("UserRole").equals("employee")) {
			throw new UnauthorizedException();
		}
		
		User u = (User)req.getAttribute("User");
		
		List<Reimbursement> allReimbursements = es.viewAllRequests(u.getUserID());
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimbursements));
		
	}

}