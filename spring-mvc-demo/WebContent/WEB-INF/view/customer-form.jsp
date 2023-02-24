<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>

<title>Customer Registration Form</title>

<style>
.error {
	color: red
}
</style>

</head>

<body>
	<div>

		<i>Fill out the form. Asterisk means required.</i> <br> <br>

		<form:form action="processForm" modelAttribute="customer">

			<br>
			<br>
	
		First name: <form:input path="firstName" />
			<br>
			<br>

			<!-- HTML for input field -->
			Last name *: <form:input path="lastName" />

			<!-- HTML for error message -->
			<form:errors path="lastName" cssClass="error" />

			<br>
			<br>
			Free passes: <form:input path="freePasses" />
			<form:errors path="freePasses" cssClass="error" />

			<br>
			<br>
			
			Postal Code: <form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" />

			<br>
			<br>
			
			Course Code: <form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" />

			<br>
			<br>

			<input type="submit" value="submit">

		</form:form>
	</div>

</body>
</html>