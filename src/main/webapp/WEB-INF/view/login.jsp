<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
<title>Spring Security Login</title>
</head>

<body>
	<p style="font-size: 20px; color: blue; font-weight: bold">Login
		form:</p><br/>
	<br />

	<c:if test="${registeredMessage == 'true'}">
	Registered successfully, now you can login:<br /></c:if>
	
	<c:if test="${wrongLogin == 'true'}">
    Wrong login,<a href="/register">register</a> if you didn't:<br /></c:if>
    
	<c:if test="${wrongPassword == 'true'}">Wrong password, try again.<br /></c:if>
	<br/>
	
	<form:form method="post" action="/login" modelAttribute="login">
		<div>
			<form:label path="username"> User Name : </form:label>
			<br />
			<form:input name="username" path="username" id="username" />
			<form:errors path="username" style="color: red" />
		</div>
		<div>
			<form:label path="password"> Password: </form:label>
			<br />
			<form:password name="password" path="password" id="password" />
			<form:errors path="password" style="color: red" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form:form>
</body>

</html>