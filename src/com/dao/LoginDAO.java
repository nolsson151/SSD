package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO extends DAOBase {
	
	String sql = "select * from users where email=? and pass=?";

	public LoginDAO() {
		super();
		
	}
	
	public boolean check(String email, String pass) {
		try {
			super.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				return true;
				
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();		
		}
		
		return false;
	}
}
