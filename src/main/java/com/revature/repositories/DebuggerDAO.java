package com.revature.repositories;

import java.sql.Timestamp;

public class DebuggerDAO {

	public static void main(String[] args) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		System.out.println(timestamp);

	}

}
