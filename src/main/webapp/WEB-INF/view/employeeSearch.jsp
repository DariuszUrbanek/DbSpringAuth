<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
<title>Spring Employee Search</title>
</head>

<body>
	<h2>Employee search:</h2>

	<c:if test="${notFound == 'true'}">
        Can't find employee for specified employee number: <c:out
			value="${incorrectNo}" />
		<br />
		<br />
	</c:if>

	<form:form method="post" action="/employeeSearch" modelAttribute="form">
		<span>Enter employee number:</span><br/>
		<form:input path="empNo"></form:input>
		<form:errors path="empNo" style="color: red" />
		<br /><br/>
		<input type="submit" value="Search" />
	</form:form>
	<br/>
	<a href="/employeeSearchByName">Search by name instead.</a>
	<br/><br/>
	<a href="/home">HOME</a>
</body>


</html>