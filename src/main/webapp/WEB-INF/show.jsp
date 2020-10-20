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
	<h1><c:out value="${idea.ideaName}"/></h1>
	<p>Creator:  <c:out value="${idea.creator.name}"/></p>
	
	<c:if test="${user.id == idea.creator.id}">
		<a href="/ideas/${idea.id}/edit"><button>Edit</button></a>
		<br>
		<form action="/ideas/delete/${idea.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="delete">
		</form>
	    <br>
	</c:if>
	
	    <br>
	    <h2>Users who liked the idea:</h2>
	    
	    <table>
	    <thead>
	        <tr>
	            <th>Name:</th>
	        </tr>
	    </thead>
	    <tbody>
		    	<c:forEach items="${idea_likers}" var="likers">
		    	<tr>
		            	<td><c:out value="${likers.name}"/></td>
		    	</tr>
		        </c:forEach>
	    </tbody>
	</table>
	    
	    
        <br>
        <br>
        <a href="/ideas">Back to Ideas</a><br>
</body>
</html>