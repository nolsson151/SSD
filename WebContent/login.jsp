<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.html"></jsp:include>


	<form action="Login" method="post">
		<p>Enter email: <input type="email" name="email" required>
		<p>Enter password: <input type="password" name="password" required>
	
	
		<input type="submit" value="Login">
	</form>

</body>
</html>