package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.models.User;

public class RegisterDAO extends DAOBase{
	
	String isUser = "select * from users where email=?";
	String newUser = "insert into users(fname, lname, email, pass) values(?,?,?,?)";
	
	public RegisterDAO() {
		super();
	}
	
	public boolean check(String email)
	{
		try {
			super.getConnection();
			PreparedStatement st = connection.prepareStatement(isUser);
			st.setString(1, email);
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
	public boolean registerNewUser(String fName, String lName, String email, String pass) {
		
		try (PreparedStatement ps = getConnection().prepareStatement(newUser)) {

            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, email);
            ps.setString(4, pass);
            
       
            int count = ps.executeUpdate();
           

            if (count == 1) {

                return true;

            } else {

                return false;

            }

        } catch (SQLException error) {
        	System.out.println("A BIG BAD ERROR OCCURED!");
            return false;
        }
	}
	
	public boolean validateNewUser(User user) {
		
		String[] inputs = {user.getfName(),user.getlName(),user.getEmail(), user.getPass()};
		
		for(String s : inputs) {
			if(s.length() == 0 && s.isEmpty()) {
			return true;
			
			}	
		}
		
		return false;
	}
}
