<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
The customer Name is  : ${customer.firstName}  ${customer.lastName} <br> <br>  freePasses :::  ${customer.freePasses}

<br> <br> Postal Code :: ${customer.postalCode}
<br> <br> Coarse Code :: ${customer.courseCode}
 

 </body>
</html>