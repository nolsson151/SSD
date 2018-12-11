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

import com.dao.LoginDAO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		LoginDAO dao = new LoginDAO();
		
		if(dao.check(email, pass)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("home.jsp");
			try {
				dao.close();
			} 
			catch (SQLException e) {
				System.out.println("SQL error, send help!");
			}
		}
		else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either email or password is wrong.</font>");
            rd.include(request, response);
		
			 
		}
	}
}