<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In and Registration</title>
</head>
<body>
<h1>Register!</h1>
    <p style="color:red"><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
    	<p>
            <form:label path="firstName">First Name:</form:label>
            <form:input type="firstName" path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input type="lastName" path="lastName"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>

        </p>
        <input type="submit" value="Register!"/>
    </form:form>
    <h2>or</h2><br>
    
    
	<h1>Login</h1>
	    <p style="color:red"><c:out value="${error}" /></p>
	    <form method="post" action="/login">
   
	        <p>
	            <label for="email">Email</label>
	            <input type="text" id="email" name="email"/>
	        </p>
	        <p>
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="submit" value="Login!"/>
	    </form>    
</body>
</html>