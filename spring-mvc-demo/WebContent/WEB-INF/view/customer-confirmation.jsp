<!--This line gives the possibility to use the for each loop from the JSP lib-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>


<body>

	Customer Confirmed 
	<br>
	${customer.firstName} 
	${customer.lastName}
	
	<br>
	Free passes:${customer.freePasses}
	
	<br><br>
	Postal Code:${customer.postalCode}
	
	<br><br>
	Course Code:${customer.courseCode}

</body>



</html>