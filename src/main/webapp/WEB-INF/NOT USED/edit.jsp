<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ideas</title>
</head>
<body>

<h1>Edit <c:out value="${idea.ideaName}"/></h1><br>


    <form:form action="/ideas/${idea.id}/edit" method="post" modelAttribute="idea">
        <form:label path="ideaName">Content:</form:label>
            <p style="color:red"><c:out value="${nameError}"/></p>
            <form:input path="ideaName"/>
        <br>
        <br>
       <input type="submit" value="Submit"/>
        <br>
        <br>
    </form:form>
       <form action="/ideas/delete/${idea.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">
        </form>
        
        <br>
        <br>
        <br>
        <a href="/ideas">Back to Ideas</a><br>


</body>
</html>