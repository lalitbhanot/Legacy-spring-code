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
The student Name is  : ${student.firstName}  ${student.lastName} 
 <br><br> Country :  ${student.country} 
 <br><br> Language :  ${student.favLang }   
 <br><br> Operating System : 
 
 <ul>
 <c:forEach var="temp" items="${student.operatingSystem}">
 <li> ${temp} </li>
  </c:forEach>
 </ul>

 </body>
</html>