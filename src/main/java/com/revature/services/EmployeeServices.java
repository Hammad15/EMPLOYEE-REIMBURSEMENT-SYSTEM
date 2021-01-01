package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbPostgresDAO;

public class EmployeeServices {
	
	ReimbPostgresDAO reimbDAO = new ReimbPostgresDAO();

	public void submitRequest(int userID, int amount, String description, String receipt, String type) {
		
		reimbDAO.submitRequest(userID, amount, description, receipt, type);
		
	}
	
	public String checkStatus(int reimbID) {
				
		return reimbDAO.checkRequest(reimbID);
	}
	
	public List<Reimbursement> viewAllRequests(int userID) {
		
		return reimbDAO.viewRequests(userID);
		
	}

}
