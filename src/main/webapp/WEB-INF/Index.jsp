<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Budge-it!</title>
</head>
<body>

<h1>HELLOOOOOOO</h1>
<h1>Welcome, <c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /></h1>

<button><a href="/budget-it/newbudget">Create a Budget</a></button>

<a href="/logout">Logout</a>

</body>
</html>