<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - Login Page</title>
</head>
<body>
 
	<center>
		<h2>Login Page</h2>
		<form method="POST" action="login">
			Username: <input id="loginUser" name="loginUser" type="text"/><br/>
			Password: <input id="loginPassword" name="loginPassword" type="password"/><br/>
			<input type="submit"/>
		</form>
	</center>
</body>
</html>