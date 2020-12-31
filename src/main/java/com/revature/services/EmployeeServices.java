package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbPostgresDAO;

public class EmployeeServices {
	
	ReimbPostgresDAO reimbDAO = new ReimbPostgresDAO();

	public List<Reimbursement> findAll() {
		
		List<Reimbursement> allReimbs = reimbDAO.findAll();
		
		return allReimbs;
	}

}
