<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Hibernate Persistence App - Users</title>
</head>
<body>
<h2>Users Data</h2>
<form:form action="user.do" method="POST" modelAttribute="user">
	<table>
		<tr>
			<td>User ID</td>
			<td><form:input path="idUsers" /></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:input path="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>Username</th>
	<th>Password</th>
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.idUsers}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>