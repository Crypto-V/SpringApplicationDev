
<!-- The next line of code is using the spring framework library when working with forms-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>


<head>

<tittle>Student Form!!</tittle>

</head>

<body>


	<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" />
		<br>
		<br>
		
		
Last name: <form:input path="lastName" />
		<br>
		<br>

		<input type="submit" value="Submit" />


	</form:form>


</body>

</html>
