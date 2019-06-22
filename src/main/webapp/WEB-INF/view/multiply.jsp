<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
    <title>Multiply</title>
</head>

<body>

	<h1>RESULT</h1>
	<c:out value="${number1}"></c:out>
	*
	<c:out value="${number2}"></c:out>
	=
	<c:out value="${result}"></c:out>

</body>

</html>