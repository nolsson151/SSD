<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
	<link rel="stylesheet" href="https://codemirror.net/lib/codemirror.css">

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
	<form action="Logout" method="post">
		<input type="submit" value="Logout" >
	</form>
	
	
	<p> Welcome ${email}
	
	<script src="https://codemirror.net/lib/codemirror.js"></script>
	<script src="https://codemirror.net/addon/edit/matchbrackets.js"></script>
	<script src="https://codemirror.net/mode/clike/clike.js"></script>

	<form action="Check" method="post" id ="code-snippet">
		<textarea rows="13" id="codesnippet-area" name="message" form="code-snippet"></textarea>
		<input type="submit" value="CheckCode">
	</form>
		
	<script>
	    var editor = CodeMirror.fromTextArea(document.getElementById('codesnippet-area'), {
	        mode: "text/x-java",
	        theme: "default",
	        lineNumbers: true
	    });
	</script>	
</body>
</html>