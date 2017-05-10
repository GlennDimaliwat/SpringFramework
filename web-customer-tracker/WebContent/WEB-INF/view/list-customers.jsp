<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Customers</title>
	
	<link type="text/css"
	      rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<!--  Just to correct the Update/Delete button for the ALTERNATE METHOD -->
	<link type="text/css"
	      rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/alternate-update-delete-customer-style.css" />
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Customer"
				   onClick="window.location.href='showFormForAdd'; return false;"
				   class="add-button" />
			
			<!-- add out html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- ORIGINAL METHOD: using GET method -->
					<!-- construct an "update" link with customer id -->
					<!--<c:url var="updateLink" value="/customer/showFormUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>-->
					<!-- construct an "delete" link with customer id -->
					<!--<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>-->
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td>
							<!-- ORIGINAL METHOD: display the update link -->
							<!-- <a href="${updateLink}">Update</a>  -->
							<!-- ALTERNATE METHOD: display the update link but not exposing the customer id in the url -->
							<form:form id="updateLinkForm" action="${pageContext.request.contextPath}/customer/showFormUpdate" method="POST">
								<input name="customerId" type="hidden" value="${tempCustomer.id}" />
								<input type="submit" value="Update" class="link-button"
									   onclick="document.getElementById('updateLinkForm').submit();" />
							</form:form>
							|
							<!-- ORIGINAL METHOD: display the delete link -->
							<!-- a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>-->
							<!-- ALTERNATE METHOD: display the delete link but not exposing the customer id in the url -->
							<!-- display the delete link -->
							<form:form id="deleteLinkForm" action="${pageContext.request.contextPath}/customer/delete" method="POST">
								<input name="customerId" type="hidden" value="${tempCustomer.id}" />
								<input type="submit" value="Delete" class="link-button"
									   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" />
							</form:form>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	
</body>

</html>