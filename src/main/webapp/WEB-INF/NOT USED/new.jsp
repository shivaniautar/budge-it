<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body>
	<h1>Create a New Idea </h1>
	<form:form action="/ideas/newidea" method="post" modelAttribute="idea">
		<form:label path="ideaName">Content:</form:label>
		<p style="color:red"><form:errors path="ideaName"/></p>
		<form:input path="ideaName"/><br>
		
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>