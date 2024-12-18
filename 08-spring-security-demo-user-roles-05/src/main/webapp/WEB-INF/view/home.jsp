<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<title>lalit Company Home Page</title>
</head>

<body>
	<h2>Lalit Company Home Page</h2>
	<hr>
	
	Welcome to the lalit company home page!
 <p>
 User : <security:authentication property="principal.username"/>
 <br> <br>
 Roles :<security:authentication property="principal.authorities"/>
 </p>
 
 <security:authorize access="hasRole('MANAGER')">
 <hr>
 <p> <a href="${pageContext.request.contextPath}/leaders"> <br> LeaderShip Meeting</a>Only for Display  </p>
<hr>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<hr>
 <p> <a href="${pageContext.request.contextPath}/systems"> <br> Systems Meeting</a>Only for Display  </p>
<hr>
</security:authorize>
<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

<input type="submit" value="Logout"/>

</form:form>
</body>

</html>