<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ideas</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}" /></h1>
	<a href="/logout">Logout</a>
	
	<h2>Ideas</h2>
	<table>
	    <thead>
	        <tr>
	            <th>Ideas:</th>
	            <th>Created By:</th>
	            <th>Likes:</th>
	            <th>Action:</th>
	        </tr>
	    </thead>
	    <tbody>
		    		<c:forEach items="${ideas}" var="idea">
		    	<tr>
		            	<td><a href="/ideas/${idea.id}"><c:out value="${idea.ideaName}"/></a></td>
		            	<td><c:out value="${idea.creator.name}"></c:out></td>
		            	<td><c:out value="${idea.users.size()}"></c:out></td>
		            	<td>
		            	<c:set var="contained" value="false" />
						<c:forEach var="liked_by_user" items="${idea.users}">
						  <c:if test="${liked_by_user.id eq user.id}">
						    <c:set var="contained" value="true" />
								<form action="/ideas/unlike/${idea.id}" method="post">
									<button type="submit">UNLike</button>
								</form>	
						  </c:if>
						</c:forEach>
		            	
							<c:if test="${idea.users.size() eq 0}">
								<form action="/ideas/like/${idea.id}" method="post">
									<button type="submit">Like</button>
								</form>	
						  </c:if>
						
						
	
	            	</td>
		    	</tr>
		            </c:forEach>
	    </tbody>
	</table><br><br>
	<p>
		<a href="/ideas/new"><button>Create an idea </button></a>
	</p>
	
	

	
	
	
</body>
</html>