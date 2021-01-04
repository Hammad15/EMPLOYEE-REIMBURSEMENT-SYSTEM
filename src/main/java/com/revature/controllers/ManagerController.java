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
import com.revature.services.ManagerServices;

public class ManagerController {

	private ManagerServices ms = new ManagerServices();

	private ObjectMapper om = new ObjectMapper();

	public void viewAllReimbs(HttpServletRequest req, HttpServletResponse res) throws IOException {


		HttpSession session = req.getSession();

		if (session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if (!session.getAttribute("UserRole").equals("manager")) {
			throw new UnauthorizedException();
		}

		List<Reimbursement> allReimbs = ms.viewAllRequests();

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimbs));

	}

	public void viewAllReimbsByUserID(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		String userID_S = req.getParameter("UserID");
		
		int userID = Integer.parseInt(userID_S);

		HttpSession session = req.getSession();

		if (session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if (!session.getAttribute("UserRole").equals("manager")) {
			throw new UnauthorizedException();
		}

		List<Reimbursement> allReimbs = ms.viewAllRequestsByID(userID);

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimbs));

	}

	public void viewAllReimbsByStatus(HttpServletRequest req, HttpServletResponse res) throws IOException {

		System.out.println("Debugging Pending Request Servlet");
		
		Reimbursement reimb = om.readValue(req.getInputStream(), Reimbursement.class);
		
		System.out.println(reimb);

		HttpSession session = req.getSession();

		if (session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if (!session.getAttribute("UserRole").equals("manager")) {
			throw new UnauthorizedException();
		}

		List<Reimbursement> allReimbs = ms.viewAllRequestsByStatus(reimb.getReimbStatus());
		
		System.out.println(allReimbs);

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimbs));

	}
	
	public void viewAllReimbsByType(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		String type = req.getParameter("ReimbType");

		HttpSession session = req.getSession();

		if (session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if (!session.getAttribute("UserRole").equals("manager")) {
			throw new UnauthorizedException();
		}

		List<Reimbursement> allReimbs = ms.viewAllRequestsByType(type);

		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimbs));

	}
	
	public void approveReimbRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		System.out.println("Debugging Approve Request Servlet");
		
		Reimbursement reimb = om.readValue(req.getInputStream(), Reimbursement.class);
		
		System.out.println(reimb.getReimbID());

		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("User");

		if (session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if (!session.getAttribute("UserRole").equals("manager")) {
			throw new UnauthorizedException();
		}

		ms.approveRequest(reimb.getReimbID(), u.getUserID());
		
		System.out.println("The reimbursement request with ID: " + reimb.getReimbID() + " has been approved");

		res.setStatus(200);
		res.getWriter().write("The reimbursement request with ID: " + reimb.getReimbID() + " has been approved");

	}
	
	public void denyReimbRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		System.out.println("Debugging Deny Request Servlet");
		
		Reimbursement reimb = om.readValue(req.getInputStream(), Reimbursement.class);
		
		System.out.println(reimb.getReimbID());

		HttpSession session = req.getSession();
		
		User u = (User)session.getAttribute("User");

		if (session.getAttribute("UserRole") == null) {
			throw new UnauthenticatedException();
		} else if (!session.getAttribute("UserRole").equals("manager")) {
			throw new UnauthorizedException();
		}

		ms.denyRequest(reimb.getReimbID(), u.getUserID());

		res.setStatus(200);
		res.getWriter().write("The reimbursement request with ID: " + reimb.getReimbID() + " has been approved");

	}

}
