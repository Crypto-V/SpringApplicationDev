
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
		
		Country:
		
		<form:select path="country">

			<form:options items = "${student.countryOptions}" />
			

		</form:select>

		<br>
		<br>
		
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br>
		<br>
		
		Favorite OS:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		MAC <form:checkbox path="operatingSystems" value="MAC"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		
		<br>
		<br>

		<input type="submit" value="Submit" />


	</form:form>






</body>

</html>
