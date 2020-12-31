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
import com.revature.services.EmployeeServices;

public class EmployeeController {

	private EmployeeServices es = new EmployeeServices();
	
	private ObjectMapper om = new ObjectMapper();
	

	public void findAllReimRequests(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession sess = req.getSession();
		
		if(sess.getAttribute("User-Role") == null) {
			throw new UnauthenticatedException();
		} else if(!sess.getAttribute("User-Role").equals("Admin")) {
			throw new UnauthorizedException();
		}
		List<Reimbursement> allReimbursements = es.findAll();
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimbursements));
		
	}
	
}