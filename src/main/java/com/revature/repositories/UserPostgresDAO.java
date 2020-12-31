package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserPostgresDAO implements UserDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from users where username = ? and \"password\" = ? ;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, username);
			getUser.setString(2, password);
			
			ResultSet res = getUser.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUserID(res.getInt("user_id"));
				u.setUsername(res.getString("username"));
				u.setPassword(res.getString("password"));
				u.setFirstName(res.getString("first_name"));
				u.setLastName(res.getString("last_name"));
				u.setEmail(res.getString("email"));
				u.setUserRoleID(res.getInt("user_role_id"));
				
				return u;
			}else {
				throw new UserNotFoundException("Username Not Found", 401);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException("Oops, something went wrong", 500);
		} finally {
			cf.releaseConnection(conn);
		}
	}

}
