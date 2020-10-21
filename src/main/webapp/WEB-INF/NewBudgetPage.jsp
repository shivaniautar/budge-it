<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Budge-it</title>
</head>
<body>

<h1>NEW BUDGET PAGE</h1>

	<form:form action="/newbudget" method="post" modelAttribute="budget">
		<form:label path="budgetAmount">Content:</form:label>
		<p style="color:red"><form:errors path="budgetAmount"/></p>
		<form:input path="budgetAmount"/><br>
		
		<input type="submit" value="Create"/>
	</form:form>



</body>
</html>