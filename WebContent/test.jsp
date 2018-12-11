<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
<h3>Vulnerability Report</h3>

<p>Below is your report of Java vulnerabilities found in your code
<br>

	<c:forEach items="${report}" var="reportItem">
		${reportItem} <br>
	</c:forEach>

</body>
</html>