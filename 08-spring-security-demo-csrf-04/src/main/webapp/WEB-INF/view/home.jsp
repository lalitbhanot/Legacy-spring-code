<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>

<head>
	<title>lalit Company Home Page</title>
</head>

<body>
	<h2>Lalit Company Home Page</h2>
	<hr>
	
	Welcome to the lalit company home page!


<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

<input type="submit" value="Logout"/>

</form:form>
</body>

</html>