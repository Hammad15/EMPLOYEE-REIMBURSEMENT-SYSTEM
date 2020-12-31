package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.InvalidStatusTypeException;
import com.revature.exceptions.ReimbursementTypeNotFoundException;
import com.revature.exceptions.ReimbursementsNotFoundException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbPostgresDAO implements ReimbDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public List<Reimbursement> findAll() throws ReimbursementsNotFoundException, InternalErrorException {

		Connection conn = cf.getConnection();
		try {
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			String sql = "select * from reimbursements;";
			PreparedStatement getReimbursements = conn.prepareStatement(sql);

			ResultSet res = getReimbursements.executeQuery();

			while (res.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(res.getInt("reimb_id"));
				r.setReimbAmount(res.getInt("reimb_amount"));
				r.setReimbSubmitted(res.getTimestamp("reimb_submitted"));
				r.setReimbApproved(res.getTimestamp("reimb_approved"));
				r.setReimbDescription(res.getString("reimb_description"));
				r.setReimbReceipt(res.getString("reimb_receipt"));
				r.setReimbAuthor(res.getInt("reimb_author"));
				r.setReimbResolver(res.getInt("reimb_author"));
				r.setReimbStatus(res.getString("reimb_author"));
				r.setReimbType(res.getString("reimb_author"));
				reimbursements.add(r);
			}
			if (reimbursements.isEmpty()) {
				throw new ReimbursementsNotFoundException("No request for a reimbursement has evener been made", 401);

			} else {
				return reimbursements;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public List<Reimbursement> findAllByStatus(String status)
			throws ReimbursementTypeNotFoundException, InvalidStatusTypeException, InternalErrorException {

		Connection conn = cf.getConnection();
		try {

			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

			String sql = "select * from reimbursements where reimb_status = ?;";
			PreparedStatement getReimbursementsByStatus = conn.prepareStatement(sql);
			getReimbursementsByStatus.setString(1, status);

			ResultSet res = getReimbursementsByStatus.executeQuery();

			while (res.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(res.getInt("reimb_id"));
				r.setReimbAmount(res.getInt("reimb_amount"));
				r.setReimbSubmitted(res.getTimestamp("reimb_submitted"));
				r.setReimbApproved(res.getTimestamp("reimb_approved"));
				r.setReimbDescription(res.getString("reimb_description"));
				r.setReimbReceipt(res.getString("reimb_receipt"));
				r.setReimbAuthor(res.getInt("reimb_author"));
				r.setReimbResolver(res.getInt("reimb_author"));
				r.setReimbStatus(res.getString("reimb_author"));
				r.setReimbType(res.getString("reimb_author"));
				reimbursements.add(r);
			}
			if (reimbursements.isEmpty()) {
				throw new ReimbursementTypeNotFoundException("There are no " + status + "reimbursement requests", 401);

			} else {
				return reimbursements;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public List<Reimbursement> findAllByType(String type)
			throws ReimbursementTypeNotFoundException, InvalidStatusTypeException, InternalErrorException {
		Connection conn = cf.getConnection();
		try {

			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

			String sql = "select * from reimbursements where reimb_type = ?;";
			PreparedStatement getReimbursementsByType = conn.prepareStatement(sql);
			getReimbursementsByType.setString(1, type);

			ResultSet res = getReimbursementsByType.executeQuery();

			while (res.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(res.getInt("reimb_id"));
				r.setReimbAmount(res.getInt("reimb_amount"));
				r.setReimbSubmitted(res.getTimestamp("reimb_submitted"));
				r.setReimbApproved(res.getTimestamp("reimb_approved"));
				r.setReimbDescription(res.getString("reimb_description"));
				r.setReimbReceipt(res.getString("reimb_receipt"));
				r.setReimbAuthor(res.getInt("reimb_author"));
				r.setReimbResolver(res.getInt("reimb_author"));
				r.setReimbStatus(res.getString("reimb_author"));
				r.setReimbType(res.getString("reimb_author"));
				reimbursements.add(r);
			}
			if (reimbursements.isEmpty()) {
				throw new ReimbursementTypeNotFoundException("There are no reimbursement requests of the type " + type, 401);

			} else {
				return reimbursements;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
		
	}


	@Override
	public List<Reimbursement> findAll(int userID) throws UserNotFoundException {

		Connection conn = cf.getConnection();
		try {

			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

			String sql = "select * from reimbursements where reimb_author = ?;";
			PreparedStatement getReimbursementsByStatus = conn.prepareStatement(sql);
			getReimbursementsByStatus.setInt(1, userID);

			ResultSet res = getReimbursementsByStatus.executeQuery();

			while (res.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(res.getInt("reimb_id"));
				r.setReimbAmount(res.getInt("reimb_amount"));
				r.setReimbSubmitted(res.getTimestamp("reimb_submitted"));
				r.setReimbApproved(res.getTimestamp("reimb_approved"));
				r.setReimbDescription(res.getString("reimb_description"));
				r.setReimbReceipt(res.getString("reimb_receipt"));
				r.setReimbAuthor(res.getInt("reimb_author"));
				r.setReimbResolver(res.getInt("reimb_author"));
				r.setReimbStatus(res.getString("reimb_author"));
				r.setReimbType(res.getString("reimb_author"));
				reimbursements.add(r);
			}
			if (reimbursements.isEmpty()) {
				throw new ReimbursementsNotFoundException(
						"There are no reimbursement requests for the given user ID: " + userID, 401);

			} else {
				return reimbursements;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public void submitRequest(int userID, int amount, String description, String receipt, String type)
			throws InternalErrorException {

		Connection conn = cf.getConnection();

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		try {

			String sql = "insert into reimbursements (reimb_amount, reimb_submitted, reimb_description, "
					+ "reimb_receipt, reimb_author, reimb_type) values (?, ?, ?, ?, ?, ?);";
			PreparedStatement submitReimbRequest = conn.prepareStatement(sql);
			submitReimbRequest.setInt(1, amount);
			submitReimbRequest.setTimestamp(2, timestamp);
			submitReimbRequest.setString(3, description);
			submitReimbRequest.setString(4, receipt);
			submitReimbRequest.setInt(5, userID);
			submitReimbRequest.setString(6, type);

			submitReimbRequest.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public void approveReq(int reimbID) throws InternalErrorException {

		Connection conn = cf.getConnection();

		try {

			String sql = "update reimbursements set reimb_status = 'approved' where reimb_id = ?;";
			PreparedStatement approveReimbRequest = conn.prepareStatement(sql);
			approveReimbRequest.setInt(1, reimbID);

			approveReimbRequest.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}

	}

	@Override
	public void denyReq(int reimbID) throws InternalErrorException {
		
		Connection conn = cf.getConnection();

		try {

			String sql = "update reimbursements set reimb_status = 'denied' where reimb_id = ?;";
			PreparedStatement approveReimbRequest = conn.prepareStatement(sql);
			approveReimbRequest.setInt(1, reimbID);

			approveReimbRequest.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public String checkRequest(int reimbID) throws InternalErrorException {

		Connection conn = cf.getConnection();
		try {
			
			String status = null;

			String sql = "select * from reimbursements where reimb_id = ?;";
			PreparedStatement getReimbursementsByID = conn.prepareStatement(sql);
			getReimbursementsByID.setInt(1, reimbID);

			ResultSet res = getReimbursementsByID.executeQuery();

			while (res.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(res.getInt("reimb_id"));
				r.setReimbAmount(res.getInt("reimb_amount"));
				r.setReimbSubmitted(res.getTimestamp("reimb_submitted"));
				r.setReimbApproved(res.getTimestamp("reimb_approved"));
				r.setReimbDescription(res.getString("reimb_description"));
				r.setReimbReceipt(res.getString("reimb_receipt"));
				r.setReimbAuthor(res.getInt("reimb_author"));
				r.setReimbResolver(res.getInt("reimb_author"));
				r.setReimbStatus(res.getString("reimb_author"));
				r.setReimbType(res.getString("reimb_author"));
				
				status = r.getReimbStatus();	
			}
			
			if (status == null) {
				throw new ReimbursementsNotFoundException("Please enter the correct Request Number", 401);
			} else {
				return status;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
	}

	@Override
	public List<Reimbursement> viewRequests(int userID) throws InternalErrorException {
		
		Connection conn = cf.getConnection();
		
		try {
			
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			
			String sql = "select * from reimbursements where reimb_author = ?;";
			PreparedStatement getReimbursements = conn.prepareStatement(sql);
			
			getReimbursements.setInt(1, userID);

			ResultSet res = getReimbursements.executeQuery();

			while (res.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(res.getInt("reimb_id"));
				r.setReimbAmount(res.getInt("reimb_amount"));
				r.setReimbSubmitted(res.getTimestamp("reimb_submitted"));
				r.setReimbApproved(res.getTimestamp("reimb_approved"));
				r.setReimbDescription(res.getString("reimb_description"));
				r.setReimbReceipt(res.getString("reimb_receipt"));
				r.setReimbAuthor(res.getInt("reimb_author"));
				r.setReimbResolver(res.getInt("reimb_author"));
				r.setReimbStatus(res.getString("reimb_author"));
				r.setReimbType(res.getString("reimb_author"));
				reimbursements.add(r);
			}
			if (reimbursements.isEmpty()) {
				throw new ReimbursementsNotFoundException("You have not made any reimbursement requests", 401);

			} else {
				return reimbursements;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 501);
		} finally {
			cf.releaseConnection(conn);
		}
		
	}
	
}
