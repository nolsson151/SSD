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

<form action="Register" method="post">
	<p>First name: <input type="text" name="fname" required pattern="[a-zA-Z]{2,20}" title="Must be between 2 and 20 letters">
	<p>Last name: <input type="text" name="lname" required pattern="[a-zA-Z]{2,20}" title="Must be between 2 and 20 letters">
	<p>Email: <input type="email" name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Must use valid email format.">
	<p>Password: <input type="password" name="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters">
	<input type="submit" value="Register">



</form>

</body>
</html>