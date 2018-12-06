package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegisterDAO;
import com.models.User;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		User newUser = new User(fName, lName, email, pass);
		
		RegisterDAO dao = new RegisterDAO();
		if(dao.check(email)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
			PrintWriter out = response.getWriter();
            out.println("<font color=red>This email is already registered</font>");
            rd.include(request, response);
            try {
				dao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL error, send help!");
			}
		}
		else if(dao.validateNewUser(newUser)){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
			PrintWriter out = response.getWriter();
            out.println("<font color=red>Invalid input! Ensure all data is correct!</font>");
            rd.include(request, response);
		}
		else{
			
			dao.registerNewUser(newUser);
			PrintWriter out = response.getWriter();
            out.println("<font color=green>You are now registered! Please log in</font>");
            response.sendRedirect("login.jsp");
            try {
				dao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
