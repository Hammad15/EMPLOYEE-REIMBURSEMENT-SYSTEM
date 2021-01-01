package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbDAO;
import com.revature.repositories.ReimbPostgresDAO;

public class ManagerServices {

	ReimbDAO reimbDAO = new ReimbPostgresDAO();

	
	public void approveRequest(int reimbID, int userID) {

		reimbDAO.approveReq(reimbID, userID);

	}

	public void denyRequest(int reimbID, int userID) {

		reimbDAO.denyReq(reimbID, userID);

	}

	public List<Reimbursement> viewAllRequests() {

		return reimbDAO.findAll();

	}

	public List<Reimbursement> viewAllRequestsByID(int userID) {

		return reimbDAO.findAll(userID);

	}

	public List<Reimbursement> viewAllRequestsByType(String type) {

		return reimbDAO.findAllByType(type);

	}

	public List<Reimbursement> viewAllRequestsByStatus(String status) {

		return reimbDAO.findAllByStatus(status);

	}

}
