<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager</h2>
		</div>

	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd' ; return false"
				class="add-button" /> </br>

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempcustomer" items="${customer}">

					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempcustomer.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempcustomer.id}"></c:param>
					</c:url>
					<tr>
						<td>${tempcustomer.firstName}</td>
						<td>${tempcustomer.lastName}</td>
						<td>${tempcustomer.email}</td>
						<td><a href="${updateLink}">Update</a> <a
							href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete '))) return false">| Delete</a></td>
					</tr>

				</c:forEach>



			</table>


		</div>


	</div>

</body>
</html>