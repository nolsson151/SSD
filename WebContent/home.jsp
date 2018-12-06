<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
	<jsp:include page="header.html"></jsp:include>
	<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
		
		if(session.getAttribute("email") == null){
			
			
			response.sendRedirect("accessDenied.jsp");
		}
	%>
	
	<p> Welcome ${email}
	
<form action="Logout" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>