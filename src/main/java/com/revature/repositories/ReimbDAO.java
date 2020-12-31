package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidStatusTypeException;
import com.revature.exceptions.ReimbursementTypeNotFoundException;
import com.revature.exceptions.ReimbursementsNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;

public interface ReimbDAO {
	
	public List<Reimbursement> findAll() throws ReimbursementsNotFoundException, InternalErrorException;
	
	public List<Reimbursement> findAllByStatus(String status) throws ReimbursementTypeNotFoundException, InvalidStatusTypeException, InternalErrorException;
	
	public List<Reimbursement> findAllByType(String type) throws ReimbursementTypeNotFoundException, InvalidStatusTypeException, InternalErrorException;
	
	public List<Reimbursement> findAll(int userID) throws UserNotFoundException;
	
	public void approveReq(int reimbID) throws InternalErrorException;
	
	public void denyReq(int reimbID) throws InternalErrorException;
	
	public void submitRequest(int userID, int amount, String description, String receipt, String type) throws InternalErrorException;
	
	public String checkRequest(int reimbID) throws InternalErrorException;
	
	public List<Reimbursement> viewRequests (int userID) throws InternalErrorException;
	
}
