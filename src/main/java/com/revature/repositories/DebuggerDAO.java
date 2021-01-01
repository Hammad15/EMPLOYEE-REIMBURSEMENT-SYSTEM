package com.revature.repositories;

import java.sql.Timestamp;

public class DebuggerDAO {

	public static void main(String[] args) {
		
		ReimbDAO rDAO = new ReimbPostgresDAO();
		
		UserDAO uDAO = new UserPostgresDAO();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		System.out.println(timestamp);
		
		System.out.println(uDAO.findUserByUsernameAndPassword("MH", "password"));
		
		rDAO.submitRequest(1, 1000, "For SAE Conference", "100001", "education");
		
		rDAO.submitRequest(1, 2000, "For CSME Conference", "100001", "research");
		
		rDAO.approveReq(1, 1);
		
		rDAO.denyReq(2, 1);
		
		System.out.println(rDAO.checkRequest(2));
		
		System.out.println(rDAO.viewRequests(1));
		
		System.out.println(rDAO.findAll());
		
		System.out.println(rDAO.findAll(1));
		
		System.out.println(rDAO.findAllByStatus("pending"));
		
		System.out.println(rDAO.findAllByType("education"));

	}

}
