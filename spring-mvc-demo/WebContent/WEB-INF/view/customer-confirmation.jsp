<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
<title>Customer Confirmation</title>
</head>

<body>

	The customer is confirmed: ${customer.firstName} ${customer.lastName} <br>
	Number of Free Passes: ${customer.freePasses} <br>
	Postal Cpde: ${customer.postalCode} <br>
	Course Code: ${customer.courseCode}
</body>

</html>