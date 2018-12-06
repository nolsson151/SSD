package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.Password;

public class UserDAO extends DAOBase{
	
	
	public UserDAO() {
		super();
	}
	
	public String checkIsValidUser(String email, String password) throws SQLException {

        final String CHECK_USER = "SELECT email, password FROM users WHERE email=?";
        String result = "";

//        try () {
        PreparedStatement ps = connection.prepareStatement(CHECK_USER);
        // PASS THROUGH THE EMAIL INTO THE PREPARED STATEMENT
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        // CHECK IF THERE ARE RESULTS
        if (rs.next()) {

            // GET THE RESULT
            do {
                result = rs.getString(2);
            } while (rs.next());

            // CHECK THE PASSWORD AGAINST THE HASH
            if (Password.validatePassword(password, result)) {
                return email;
            } else {

                // OTHERWISE RETURN BLANK
                return "";
            }

        } else {
            // OTHERWISE RETURN BLANK
            return "";
        } 
	
	}
}
