package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utils.CodeChecker;


@WebServlet("/Check")
public class CheckCodeServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = request.getParameter("message");
		CodeChecker cc = new CodeChecker();
		List<String> report = cc.report(message);
		
		if(report.isEmpty())
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
			PrintWriter out = response.getWriter();
            out.println("<font color=red>No vulernabilies found!</font>");
            rd.include(request, response);	
		}
		
		else {
		request.setAttribute("report", report);
		request.getRequestDispatcher("/test.jsp").forward(request, response);
		}
		
		
	}

}
