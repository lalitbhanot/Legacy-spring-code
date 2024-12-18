<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		<br>
		<br>
First Name : <form:input path="firstName" />
		<br>
		<br>
Last Name : <form:input path="LastName" />
		<br>
		<br>
Country : <form:select path="country">
			<form:options items="${student.countries}" />
		</form:select>
		<br>
		<br>
Programming Languages:<br>
		<form:radiobutton path="favLang" value="Java" />Java
	<form:radiobutton path="favLang" value="c" />C	 <br>
		<form:radiobutton path="favLang" value="c++" />C++
	<form:radiobutton path="favLang" value="C#" />	C#
		<br>
		<br>
Operating System :<br>
		<form:checkbox path="operatingSystem" value="Windows" />Windows
		<form:checkbox path="operatingSystem" value="Windows 7" />Windows 7
		<form:checkbox path="operatingSystem" value="Windows 10" />Windows 10

		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>





</body>
</html>